package org.mryan.eventnice.utils;

import org.mryan.eventnice.annotation.EventReceive;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description： 方法相关工具类
 * @Author MRyan
 * @Date 2021/10/9 17:59
 */
public class MethodHelper {

    /**
     * 用途过滤Method 减少不必要遍历
     *
     * @param method
     * @return
     */
    public static boolean isConditionMethod(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        //过滤非@EventReceive注解标识方法
        if (!method.isAnnotationPresent(EventReceive.class) && !method.isSynthetic()) {
            return true;
        }
        //过滤非public方法
        if (!Modifier.isPublic(method.getModifiers())) {
            return true;
        }
        if (parameterTypes[0].isPrimitive()) {
            return true;
        }
        //过滤volatile方法，修复Java编译器自动添加bridge方法造成的方法重复的问题
        if (Modifier.isVolatile(method.getModifiers())) {
            return true;
        }
        return false;
    }

    /**
     * 过滤条件，大幅提高父类查找的效率，减少不必要的遍历
     *
     * @param clazz
     * @return
     */
    public static boolean shouldSkipClass(final Class<?> clazz) {
        final String clsName = clazz.getName();
        return Object.class.equals(clazz)
                || clsName.startsWith("java.")
                || clsName.startsWith("javax.");
    }

}
