/************************************************************
 * Copyright (c) 2007-2019 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.cust.export.create;

public class ExportServiceImpl implements ExportService {
    @Override
    public String determineSupplementProcess(String company, String plant) {
        return "dummy.bpmn";
    }
}
