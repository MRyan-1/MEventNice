package cn.wormholestack.eventnicetest.test.listener.hierarchy;

import cn.wormholestack.eventnicetest.test.event.hierarchy.Apple;
import cn.wormholestack.eventnicetest.test.event.hierarchy.Fruit;
import cn.wormholestack.eventnice.annotation.EventReceive;

/**
 * @description： FruitEaterListener
 * @Author MRyan
 * @Date 2021/10/10 15:08
 * @Version 1.0
 */
public class FruitEaterListener {

    @EventReceive
    public void eatFruit(Fruit fruit) {
        System.out.println("eatFruit(Fruit " + fruit + ")");
    }

    @EventReceive
    public void eatApple(Apple apple) {
        System.out.println("eatApple(" + apple + ")");
    }
}
