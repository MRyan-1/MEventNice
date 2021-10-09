package org.mryan.eventnice.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
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
     * @param type
     * @param annotation
     * @return
     */
    @Override
    public Set<MethodInfo> huntingMethods(Object target, Class<?> targetClass) {
        return null;
    }
}
