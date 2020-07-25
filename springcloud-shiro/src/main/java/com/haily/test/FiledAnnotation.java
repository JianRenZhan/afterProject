package com.haily.test;


import java.lang.annotation.*;

/**
 * @author JRKJ
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiledAnnotation {
    String value() default "GetFiledAnnotation";
}
