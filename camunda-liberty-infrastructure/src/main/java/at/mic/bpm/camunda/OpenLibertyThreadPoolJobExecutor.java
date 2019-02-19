/************************************************************
 * Copyright (c) 2007-2018 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.bpm.camunda;

import lombok.extern.java.Log;
import org.camunda.bpm.engine.impl.ProcessEngineImpl;
import org.camunda.bpm.engine.impl.ProcessEngineLogger;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutor;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutorLogger;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Log
public class OpenLibertyThreadPoolJobExecutor extends JobExecutor {

    private final ManagedExecutorService executorService;
    private final static JobExecutorLogger LOG = ProcessEngineLogger.JOB_EXECUTOR_LOGGER;

    OpenLibertyThreadPoolJobExecutor() {
        super();
        try {
            final InitialContext context = new InitialContext();
            executorService = (ManagedExecutorService) context.lookup("wm/camunda-bpm-workmanager");
            setMaxJobsPerAcquisition(20);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void startExecutingJobs() {
        executorService.submit(acquireJobsRunnable);
    }

    @Override
    protected void stopExecutingJobs() {
//        try {
////            executorService.awaitTermination(10L, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            LOG.interruptedWhileShuttingDownjobExecutor(e);
//        }
        jobAcquisitionThread = null;
    }

    @Override
    public void executeJobs(List<String> jobIds, ProcessEngineImpl processEngine) {
        try {
            executorService.execute(getExecuteJobsRunnable(jobIds, processEngine));

        } catch (RejectedExecutionException e) {

            logRejectedExecution(processEngine, jobIds.size());
            rejectedJobsHandler.jobsRejected(jobIds, processEngine, this);

        }
    }


}
