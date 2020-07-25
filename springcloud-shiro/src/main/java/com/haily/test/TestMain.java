package com.haily.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) throws Exception {
        // 装载一个类并且对其进行实例化的操作 装载过程中使用到的类加载器是当前类
        Class cls = Class.forName("com.haily.test.Worker");
        //获取到方法的数组
        Method[] method = cls.getMethods();
        //判断Worker类上是否有TypeAnnotation注解
        boolean flag = cls.isAnnotationPresent(TypeAnnotation.class);
        //获取Worker类上是TypeAnnotation注解值
        if (flag) {
            TypeAnnotation typeAnno = (TypeAnnotation) cls.getAnnotation(TypeAnnotation.class);
            System.out.println("@TypeAnnotation值:" + typeAnno.value());
        }

        //方法上注解
//        List<Method> list = new ArrayList<Method>();
//        for (int i = 0; i < method.length; i++) {
//            list.add(method[i]);
//        }

        for (Method m : method) {
            MethodAnnotation methodAnno = m.getAnnotation(MethodAnnotation.class);
            if (methodAnno == null){
                continue;
            }
            System.out.println( "方法名称:" + m.getName());
            System.out.println("方法上注解name = " + methodAnno.name());
            System.out.println("方法上注解url = " + methodAnno.url());
        }
        //属性上注解
        List<Field> fieldList = new ArrayList<>();
        // 访问所有字段
        for (Field f : cls.getDeclaredFields()) {
            FiledAnnotation filedAno = f.getAnnotation(FiledAnnotation.class);
            System.out.println( "属性名称:" + f.getName());
            System.out.println("属性注解值FiledAnnotation = " + filedAno.value());
        }
    }

}
