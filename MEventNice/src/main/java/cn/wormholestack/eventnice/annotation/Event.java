package cn.wormholestack.eventnice.annotation;

import java.lang.annotation.*;

/**
 * @description： 标识一个类或接口为事件
 * @Author MRyan
 * @Date 2021/10/9 00:06
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Event {

}