package cn.wormholestack.eventnice.annotation;

import java.lang.annotation.*;

/**
 * @description： Annotation:标识一个方法为事件接收器方法
 * @Author MRyan
 * @Date 2021/10/7 22:50
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EventReceive {

}
