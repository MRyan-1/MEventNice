package cn.wormholestack.eventnicetest.test.listener.hierarchy;

import cn.wormholestack.eventnice.annotation.EventReceive;
import cn.wormholestack.eventnicetest.test.event.hierarchy.Apple;
import cn.wormholestack.eventnicetest.test.event.hierarchy.Fruit;

/**
 * @description： FruitEaterListener
 * @Author MRyan
 * @Date 2021/10/10 15:08
 * @Version 1.0
 */
public class FruitEaterListener {

    @EventReceive
    public void eat(Fruit fruit) {
        System.out.println("eat(Fruit " + fruit + ")");
    }

    @EventReceive
    public void eat(Apple apple) {
        System.out.println("eat(" + apple + ")");
    }
}
