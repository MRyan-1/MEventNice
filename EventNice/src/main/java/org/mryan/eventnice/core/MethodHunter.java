package org.mryan.eventnice.core;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @description： method捕猎者
 * @Author MRyan
 * @Date 2021/10/8 23:59
 * @Version 1.0
 */
public interface MethodHunter {

    /**
     * 捕获指定方法
     *
     * @param type
     * @param annotation
     * @return
     */
    Set<Method> huntingMethods(Class<?> clazz);

}
