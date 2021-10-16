package cn.wormholestack.eventnice.core;

import java.lang.reflect.Method;

/**
 * @description： 用于保存捕猎到的事件的方法信息
 * @Author MRyan
 * @Date 2021/10/9 00:20
 * @Version 1.0
 */
public class MethodInfo {

    private final Method method;

    private final Class<?> targetClass;

    private final Class<?> eventType;

    private final String name;

    public MethodInfo(final Method method, final Class<?> targetClass) {
        this.method = method;
        this.targetClass = targetClass;
        this.eventType = targetClass;
        this.name = targetClass.getName() + "." + method.getName() + "(" + eventType.getName() + ")";
    }

    public Method getMethod() {
        return method;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?> getEventType() {
        return eventType;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MethodInfo that = (MethodInfo) o;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "method=" + method +
                ", targetClass=" + targetClass +
                ", eventType=" + eventType +
                ", name='" + name + '\'' +
                '}';
    }
}
