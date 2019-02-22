package at.mic.bpm.camunda;

import at.mic.bpm.camunda.delegate.DetermineSupplementProcessDelegate;
import at.mic.bpm.camunda.delegate.ExportLogicDelegate;
import at.mic.bpm.camunda.delegate.StartDeclarationDelegate;
import at.mic.bpm.camunda.service.ExportProcessVariables;
import at.mic.cust.export.create.ExportService;
import at.mic.cust.export.create.InvoiceService;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.execute;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.historyService;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.init;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.job;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.processEngine;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.taskService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Deployment(resources = {"MIC_Export_VollstAnmeldung.bpmn", "AllgemeineDatenanreicherung.bpmn", "supplementKunde1.bpmn",
        "supplementKunde2.bpmn", "dummy.bpmn"})
public class ExportProcessTest {
    @ClassRule
    @Rule
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();


    static {
    }

    @Mock
    InvoiceService invoiceService;

    @Mock
    private ExportService exportService;

    @Mock
    CamundaMessageRestSender camundaMessageRestSender;

//    @Mock
//    HealthChecker healthChecker;

    @Before
    public void setup() {
        init(rule.getProcessEngine());
        MockitoAnnotations.initMocks(this);

        Mocks.register("exportLogicDelegate", new ExportLogicDelegate(invoiceService));
        Mocks.register("startDeclarationDelegate", new StartDeclarationDelegate(camundaMessageRestSender));
//        Mocks.register("healthChecker", healthChecker);
        Mocks.register("determineSupplementProcessDelegate", new DetermineSupplementProcessDelegate(exportService));

//        when(healthChecker.isEmergency()).thenReturn(false);
        when(exportService.determineSupplementProcess(anyString(), anyString())).thenReturn("Process_dummy");
    }

    @Test
    public void testParseAndDeploy() {

    }

    @Test
    public void testHappyPath() {
        ProcessInstance processInstance = runtimeService()
                .startProcessInstanceByMessage(
                        "Message_ExportIntended",
                        "123",
                        Variables.putValue("invoiceId", "456")
                                 .putValue(ExportProcessVariables.COMPANY, "DC")
                                 .putValue(ExportProcessVariables.PLANT, "23")
                                 .putValue("invoiceId", "456").putValue("systemOnline", true));


        assertThat(processInstance).isStarted();
        execute(job()); // async before on start event

        Mockito.verify(invoiceService, times(1)).findPositionIds("456");

        // Message_DeclarationsDone
        assertThat(processInstance).isWaitingAt("Task_WaitForDeclarations");
        runtimeService().createMessageCorrelation("Message_DeclarationsDone")
                        .processInstanceBusinessKey("123")
                        .setVariable("issueList", new ArrayList())
                        .correlate();

        assertThat(processInstance).isWaitingAt("Task_SendEAD");
        List<LockedExternalTask> externalTasks = processEngine().getExternalTaskService()
                                                                .fetchAndLock(1, "junit")
                                                                .topic("sendEAD", 1_000)
                                                                .execute();
        assertThat(externalTasks).hasSize(1);
        processEngine().getExternalTaskService()
                       .complete(externalTasks.get(0).getId(), "junit");

        assertThat(processInstance).hasPassed("EndEvent_ExportSuccessful").isEnded();
    }

    @Test
    public void testEmergencyActive() {

//        when(healthChecker.isEmergency()).thenReturn(true);

        ProcessInstance processInstance = runtimeService().createProcessInstanceByKey("export_completeDeclaration")
                                                          .businessKey("123")
                                                          .setVariable("systemOnline", false)
                .startBeforeActivity("ExclusiveGateway_EmergencyCheck")
                                                          .execute();

        assertThat(processInstance).isWaitingAt("Task_Print");

        List<Task> taskList = taskService().createTaskQuery().list();
        assertThat(taskList).hasSize(1);
        taskService().complete(taskList.get(0).getId());

        assertThat(processInstance).hasPassed("EndEvent_EndedByPrint").isEnded();
    }

    @Test
    public void testCustomerSuppplement1() {
        final String company = "company1";
        final String plant = "plant1";
        final String subProcess = "Process_Supplement1";
        when(exportService.determineSupplementProcess(company, plant)).thenReturn(subProcess);

        ProcessInstance processInstance = runtimeService().createProcessInstanceByKey("export_completeDeclaration")
                                                          .businessKey("123")
                                                          .setVariable(ExportProcessVariables.COMPANY, company)
                                                          .setVariable(ExportProcessVariables.PLANT, plant)
                                                          .startBeforeActivity("BusinessRuleTask_DetermineSupplement")
                                                          .execute();
        assertThat(processInstance).isStarted();

        assertCalledSubProcess(subProcess, "StartEvent_Kunde1");

        assertThat(processInstance).hasPassed("BusinessRuleTask_DetermineSupplement", "CallActivity_Supplement");

    }

    @Test
    public void testCustomerSuppplement2() {
        final String company = "company2";
        final String plant = "plant2";
        final String subProcess2 = "Process_SupplementKunde2";
        when(exportService.determineSupplementProcess(company, plant)).thenReturn(subProcess2);

        ProcessInstance processInstance = runtimeService().createProcessInstanceByKey("export_completeDeclaration")
                                                          .businessKey("123")
                                                          .setVariable(ExportProcessVariables.COMPANY, company)
                                                          .setVariable(ExportProcessVariables.PLANT, plant)
                                                          .startBeforeActivity("BusinessRuleTask_DetermineSupplement")
                                                          .execute();
        assertThat(processInstance).isStarted();

        assertCalledSubProcess(subProcess2, "StartEvent_Kunde2");


        assertThat(processInstance).hasPassed("BusinessRuleTask_DetermineSupplement", "CallActivity_Supplement");

    }

    private void assertCalledSubProcess(String processName, String startActivityId) {
        final HistoricProcessInstance subProcess = historyService().createHistoricProcessInstanceQuery()
                                                                   .finished()
                                                                   .processDefinitionKey(processName)
                                                                   .singleResult();

        assertThat(subProcess).isNotNull();
        assertThat(subProcess.getStartActivityId(), is(equalTo(startActivityId)));

    }
}
