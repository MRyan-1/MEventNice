package org.mryan.eventnice.core;

import org.mryan.eventnice.annotation.EventReceive;
import org.mryan.eventnice.exception.EventException;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @description： method捕猎者
 * @Author MRyan
 * @Date 2021/10/9 17:57
 */
public class AnnotationMethodHunter implements MethodHunter {


    /**
     * 捕获指定的class里面使用了Annotation注解的方法
     *
     * @param clazz
     * @return
     */
    @Override
    public Set<Method> huntingMethods(Class<?> clazz) {
        Set<Method> annotatedMethods = new HashSet<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventReceive.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new EventException(String.format(
                            "Method %s has @EventReceive annotation but has %s parameters." + "Subscriber methods must have exactly 1 parameter.",
                            method, parameterTypes.length));
                }
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
