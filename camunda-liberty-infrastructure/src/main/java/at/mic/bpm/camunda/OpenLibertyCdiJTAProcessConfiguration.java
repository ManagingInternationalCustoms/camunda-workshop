/************************************************************
 * Copyright (c) 2007-2018 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.bpm.camunda;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.cdi.CdiJtaProcessEngineConfiguration;

import javax.transaction.TransactionManager;
import java.lang.reflect.InvocationTargetException;

public class OpenLibertyCdiJTAProcessConfiguration extends CdiJtaProcessEngineConfiguration {


    @Override
    protected void init() {
        initLibertyTransactionManager();
        setJobExecutor(new OpenLibertyThreadPoolJobExecutor());
        super.init();
        LogFactory.useSlf4jLogging();
    }

    private void initLibertyTransactionManager() {
        final TransactionManager transactionManager;
        try {
            transactionManager = (TransactionManager) Class.forName("com.ibm.tx.jta.TransactionManagerFactory")
                                                           .getMethod("getTransactionManager")
                                                           .invoke(null);
            setTransactionManager(transactionManager);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
