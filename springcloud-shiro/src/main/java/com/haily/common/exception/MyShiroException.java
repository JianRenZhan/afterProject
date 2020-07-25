package com.haily.common.exception;

import com.google.common.collect.Maps;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description   自定义异常
 * @Author
 * @CreateTime
 */
//增强Controller  使用  1.全局异常处理   2.全局数据绑定   3.全局数据预处理
@ControllerAdvice
public class MyShiroException {

    @ResponseBody
    //给这个方法加上@ExceptionHandler注解，这个方法就会处理类中其他方法（被@RequestMapping注解）抛出的异常。
    @ExceptionHandler(value = AuthorizationException.class)
    public Map<String,Object> defaultErrorHandler(){
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("403","权限不足");
        return hashMap;
    }

}
