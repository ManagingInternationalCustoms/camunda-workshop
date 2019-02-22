package at.mic.bpm.camunda.delegate;

import at.mic.bpm.camunda.CamundaMessageRestSender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StartDeclarationDelegate implements JavaDelegate {

    CamundaMessageRestSender camundaMessageRestSender;

    @Inject
    public StartDeclarationDelegate(CamundaMessageRestSender camundaMessageRestSender) {
        this.camundaMessageRestSender = camundaMessageRestSender;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        camundaMessageRestSender.sendMessage("http://localhost:9081/engine-rest/",
                "Message_ShipmentTransmittable",
                execution.getProcessBusinessKey(),
                null,
                null)
        ;
    }
}
