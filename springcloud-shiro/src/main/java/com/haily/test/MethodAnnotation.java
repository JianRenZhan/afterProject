package com.haily.test;


import java.lang.annotation.*;

/**
 * @author JRKJ
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {
    String name() default "MethodAnnotation";
    String url() default "https://www.cnblogs.com";
}

