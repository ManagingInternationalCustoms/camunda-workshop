package at.mic.bpm.camunda;

import at.mic.bpm.camunda.delegate.ExportLogicDelegate;
import at.mic.bpm.camunda.service.InvoiceService;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;
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

import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.*;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Deployment(resources = {"MIC_Export_VollstAnmeldung.bpmn", "AllgemeineDatenanreicherung.bpmn"})
public class ExportProcessTest {
    @ClassRule
    @Rule
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

    private static final String PROCESS_DEFINITION_KEY = "twitter-qa";

    static {
    }

    @Mock
    InvoiceService invoiceService;

    @Mock
    HealthChecker healthChecker;

    @Before
    public void setup() {
        init(rule.getProcessEngine());
        MockitoAnnotations.initMocks(this);

        Mocks.register("exportLogicDelegate", new ExportLogicDelegate(invoiceService));
        Mocks.register("healthChecker", healthChecker);

        when(healthChecker.isEmergency()).thenReturn(false);
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
                        Variables.putValue("invoiceId", "456"));


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

        when(healthChecker.isEmergency()).thenReturn(true);

        ProcessInstance processInstance = runtimeService().createProcessInstanceByKey("export_completeDeclaration")
                .businessKey("123")
                .startBeforeActivity("ExclusiveGateway_EmergencyCheck")
                .execute();

        assertThat(processInstance).isWaitingAt("Task_Print");

        List<Task> taskList = taskService().createTaskQuery().list();
        assertThat(taskList).hasSize(1);
        taskService().complete(taskList.get(0).getId());

        assertThat(processInstance).hasPassed("EndEvent_EndedByPrint").isEnded();
    }
}
