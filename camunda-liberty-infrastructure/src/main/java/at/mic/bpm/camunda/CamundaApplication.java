/************************************************************
 * Copyright (c) 2007-2018 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.bpm.camunda;

import lombok.extern.java.Log;
import org.camunda.bpm.application.AbstractProcessApplication;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationReference;
import org.camunda.bpm.application.impl.ProcessApplicationLogger;
import org.camunda.bpm.application.impl.ProcessApplicationReferenceImpl;
import org.camunda.bpm.engine.impl.ProcessEngineLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ProcessApplication("MIC Camunda Application")
@Log
public class CamundaApplication extends AbstractProcessApplication {

    private ProcessApplicationReferenceImpl reference;
    private static String MODULE_NAME_PATH = "java:module/ModuleName";
    private static String JAVA_APP_APP_NAME_PATH = "java:app/AppName";
    private static ProcessApplicationLogger LOG = ProcessEngineLogger.PROCESS_APPLICATION_LOGGER;

    @Override
    protected String autodetectProcessApplicationName() {
        try {
            InitialContext initialContext = new InitialContext();

            String appName = (String) initialContext.lookup(JAVA_APP_APP_NAME_PATH);
            String moduleName = (String) initialContext.lookup(MODULE_NAME_PATH);

            if (moduleName != null && !moduleName.equals(appName)) {
                return appName + "/" + moduleName;
            } else {
                return appName;
            }
        } catch (NamingException e) {
            LOG.exceptionWhileInitializingProcessengine(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProcessApplicationReference getReference() {
        if (reference == null) {
            reference = new ProcessApplicationReferenceImpl(this);
        }
        return reference;
    }

    public void postConstruct(@Observes @Initialized(ApplicationScoped.class) Object event) {
        log.info("Start Camunda with CDI");
        deploy();
    }

    public void preDestroyed(@Observes @Destroyed(ApplicationScoped.class) Object event) {
        isDeployed = true;
        undeploy();
        if (reference != null) {
            reference.clear();
        }
        reference = null;
    }

}
