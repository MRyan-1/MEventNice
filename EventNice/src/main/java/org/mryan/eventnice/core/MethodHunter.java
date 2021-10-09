package org.mryan.eventnice.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description： method捕猎者
 * @Author MRyan
 * @Date 2021/10/8 23:59
 * @Version 1.0
 */
public interface MethodHunter {

    /**
     * 捕获指定的class里面使用了Annotation注解的方法
     *
     * @param type
     * @param annotation
     * @return
     */
    List<Method> huntingAnnotatedMethods(final Class<?> type,
                                         final Class<? extends Annotation> annotation);

}
