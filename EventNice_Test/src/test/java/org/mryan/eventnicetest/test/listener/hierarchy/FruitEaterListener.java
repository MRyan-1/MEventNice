package org.mryan.eventnicetest.test.listener.hierarchy;

import org.mryan.eventnice.annotation.EventReceive;
import org.mryan.eventnicetest.test.event.hierarchy.Apple;
import org.mryan.eventnicetest.test.event.hierarchy.Fruit;

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
