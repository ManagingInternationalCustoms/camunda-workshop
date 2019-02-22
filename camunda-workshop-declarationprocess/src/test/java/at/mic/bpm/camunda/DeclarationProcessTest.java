package at.mic.bpm.camunda;

import org.camunda.bpm.engine.externaltask.LockedExternalTask;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.Job;
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

@Deployment(resources = {"Deklaration.bpmn", "simplifiedDeclarationMessagesDE.dmn"})
public class DeclarationProcessTest {
    @ClassRule
    @Rule
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

    private static final String PROCESS_DEFINITION_KEY = "twitter-qa";

    static {
    }

    @Mock
    CamundaMessageRestSender camundaMessageRestSender;

    @Before
    public void setup() {
        init(rule.getProcessEngine());
        MockitoAnnotations.initMocks(this);

        Mocks.register("logger", new LoggerDelegate());
        Mocks.register("declarationFinishedDelegate", new DeclarationFinishedDelegate(camundaMessageRestSender));
    }

    @Test
    public void testParseAndDeploy() {

    }

    @Test
    public void testHappyPath() {
        ProcessInstance processInstance = runtimeService()
                .startProcessInstanceByMessage(
                        "Message_ShipmentTransmittable",
                        "123"
                        );


        assertThat(processInstance).isStarted();
        execute(job()); // async before on start event

        // now MI should be executed, every single instance waiting on start event async before
        List<Job> jobs = jobQuery().activityId("StartEvent_SubProcess_Declaration").list();
        for (Job job : jobs) {
            Object currDeclId = runtimeService().getVariable(job.getExecutionId(), "currDeclId");
            execute(job); // async before start event

            execute(jobQuery().executionId(job.getExecutionId()).singleResult()); // async after SendTask_SimplifiedDeclaration

            // authorities answer
            runtimeService().createMessageCorrelation("Message_AuthorityResponse")
                    .processInstanceVariableEquals("currDeclId", currDeclId)
                    .setVariable("responseStatus", "E_EXP_REL")
                    .correlate();

            execute(jobQuery().executionId(job.getExecutionId()).singleResult()); // async after ReceiveTask_AuthoritiesAnswer

        }

        assertThat(processInstance).hasPassed("EndEvent_Released").isEnded();
    }

}
