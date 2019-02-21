package at.mic.bpm.camunda.delegate;

import at.mic.bpm.camunda.service.InvoiceService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ExportLogicDelegate implements JavaDelegate {

    private InvoiceService invoiceService;

    @Inject
    public ExportLogicDelegate(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        // load data
        String shipmentId = execution.getProcessBusinessKey();
        String invoiceId = execution.getVariable("invoiceId").toString();

        // process data
        List<String> invoicePositionIds = invoiceService.findPositionIds(invoiceId);

        // save data
        execution.setVariable("invoicePositionIds", invoicePositionIds);
    }
}
