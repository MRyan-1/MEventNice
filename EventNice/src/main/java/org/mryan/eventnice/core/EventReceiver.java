package org.mryan.eventnice.core;

import org.mryan.eventnice.utils.LoggerUtils;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description： 事件接收器
 * @Author MRyan
 * @Date 2021/10/9 00:10
 * @Version 1.0
 */
public class EventReceiver {

    /**
     * 事件目标对象
     */
    public final Object target;

    /**
     * 目标类型
     */
    public final Class<?> targetType;

    /**
     * 事件类型
     */
    public final Class<?> eventType;

    /**
     * 用于保存捕猎到的事件的方法信息
     */
    public final MethodInfo methodInfo;

    /**
     * 名字
     */
    public final String name;


    public EventReceiver(MethodInfo methodInfo, Object target) {
        this.target = target;
        this.targetType = methodInfo.getTargetClass();
        this.eventType = methodInfo.getEventType();
        this.methodInfo = methodInfo;
        this.name = methodInfo.getName();
    }

    public Object execute(EventReceiver eventReceiver, Object event) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = this.methodInfo.getMethod();
            method.setAccessible(true);
            return method.invoke(this.target, event);
        } catch (IllegalArgumentException e) {
            LoggerUtils.error(LoggerFactory.getLogger(getClass()), "Method rejected target/argument:" + event, e);
            throw e;
        } catch (IllegalAccessException e) {
            LoggerUtils.error(LoggerFactory.getLogger(getClass()), "Method became inaccessible: " + event, e);
            throw e;
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof Error) {
                throw (Error) e.getCause();
            }
            throw e;
        }
    }

    @Override
    public String toString() {
        return "EventReceiver{" +
                "target=" + target +
                ", targetType=" + targetType +
                ", eventType=" + eventType +
                ", methodInfo=" + methodInfo +
                ", name='" + name + '\'' +
                '}';
    }
}
