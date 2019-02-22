package at.mic.bpm.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */
@Named
public class DeclarationFinishedDelegate implements JavaDelegate {

  CamundaMessageRestSender camundaMessageRestSender;

  @Inject
  public DeclarationFinishedDelegate(CamundaMessageRestSender camundaMessageRestSender) {
    this.camundaMessageRestSender = camundaMessageRestSender;
  }

  public void execute(DelegateExecution execution) throws Exception {
    camundaMessageRestSender.sendMessage("http://localhost:9080/engine-rest/",
            "Message_DeclarationsDone",
            execution.getProcessBusinessKey(),
            null,
            null)
    ;
  }

}
