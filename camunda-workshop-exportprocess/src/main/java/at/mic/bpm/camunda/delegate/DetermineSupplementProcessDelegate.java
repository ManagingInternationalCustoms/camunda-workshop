/************************************************************
 * Copyright (c) 2007-2019 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.bpm.camunda.delegate;

import at.mic.bpm.camunda.service.ExportProcessVariables;
import at.mic.cust.export.create.ExportService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DetermineSupplementProcessDelegate implements JavaDelegate {

    private ExportService exportService;

    @Inject
    public DetermineSupplementProcessDelegate(ExportService exportService) {
        this.exportService = exportService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String company = (String) delegateExecution.getVariable(ExportProcessVariables.COMPANY);
        String plant = (String) delegateExecution.getVariable(ExportProcessVariables.PLANT);
        final String supplementProcess = exportService.determineSupplementProcess(company, plant);
        delegateExecution.setVariable(ExportProcessVariables.SUPPLEMENT_PROCESS, supplementProcess);
    }
}
