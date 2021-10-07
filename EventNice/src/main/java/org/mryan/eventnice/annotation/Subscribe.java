package org.mryan.eventnice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description： 注解 标明观察者中的哪个函数可以接收消息
 * @Author MRyan
 * @Date 2021/10/7 22:50
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {


}
