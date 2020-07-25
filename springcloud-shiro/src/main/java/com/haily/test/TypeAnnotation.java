package com.haily.test;

import java.lang.annotation.*;

/**
 * @author JRKJ
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TypeAnnotation {

    String value() default "Is-TypeAnnotation";

}
