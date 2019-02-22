/************************************************************
 * Copyright (c) 2007-2018 MIC Datenverarbeitung GmbH
 * All rights reserved
 ************************************************************/
package at.mic.cust.export.create;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Documented
public @interface Database {
}
