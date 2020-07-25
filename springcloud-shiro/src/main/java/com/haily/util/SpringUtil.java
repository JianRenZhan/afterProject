package com.haily.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 */
//@component就是说把这个类交给Spring管理
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    /**
     *  spring在bean初始化后会判断是不是ApplicationContextAware的子类
     *  如果该类是，setApplicationContext()方法，会将容器中ApplicationContext作为参数传入进去
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     *  通过name返回指定的bean
     */
    public static <T> T getBean(Class<T> beanClass){
        return context.getBean(beanClass);
    }



}
