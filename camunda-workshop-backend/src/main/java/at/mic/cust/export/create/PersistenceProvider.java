/************************************************************
 * Copyright (c) 2007-2018 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.cust.export.create;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class PersistenceProvider {


    @PersistenceContext(unitName = "at.mic.cust.export.PU")
    @Produces
    @Database
    private EntityManager entityManager;

}
