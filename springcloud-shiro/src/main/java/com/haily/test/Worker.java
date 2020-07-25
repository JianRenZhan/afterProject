package com.haily.test;

@TypeAnnotation(value = "doWork")
public class Worker {

    @FiledAnnotation(value = "CSDN博客")
    private String myfield = "";

    @MethodAnnotation()
    public String getDefaultInfo() {
        return "do the getDefaultInfo method";
    }

    @MethodAnnotation(name = "百度", url = "www.baidu.com")
    public String getDefineInfo() {
        return "do the getDefineInfo method";
    }
}
