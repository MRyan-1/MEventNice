package cn.wormholestack.eventnice.core;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description： 捕猎者
 * @Author MRyan
 * @Date 2021/10/8 23:59
 * @Version 1.0
 */
public interface Hunter {

    /**
     * 捕获指定方法
     *
     * @param clazz
     * @return
     */
    Set<Method> huntingMethods(Class<?> clazz);

    /**
     * 捕获指定匹配事件接收器
     *
     * @param registry 事件接收器注册中心
     * @param event
     * @return
     */
    List<EventReceiver> huntingMatchedEventReceivers(ReceiverRegistry registry, Object event);

    /**
     * 捕获当前EventReceive所有事件接收器
     *
     * @param receiver
     * @return
     */
    Map<Class<?>, Collection<EventReceiver>> huntingAllEventReceiver(Object receiver);

}
