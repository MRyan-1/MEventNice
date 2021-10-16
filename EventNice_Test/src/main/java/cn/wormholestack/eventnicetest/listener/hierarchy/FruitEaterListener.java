package cn.wormholestack.eventnicetest.listener.hierarchy;

import cn.wormholestack.eventnicetest.event.hierarchy.Apple;
import cn.wormholestack.eventnicetest.event.hierarchy.Banana;
import cn.wormholestack.eventnicetest.event.hierarchy.Fruit;
import cn.wormholestack.eventnice.annotation.EventReceive;


/**
 * @description： FruitEaterListener
 * @Author MRyan
 * @Date 2021/10/10 15:08
 * @Version 1.0
 */
public class FruitEaterListener {

    @EventReceive
    public void eat(Fruit fruit) {
        System.out.println("eatFruit(Fruit " + fruit + ")");
    }

    @EventReceive
    public void eat(Apple apple) {
        System.out.println("eatApple(" + apple + ")");
    }

    @EventReceive
    public void eat(Banana banana) {
        System.out.println("eatBanana(" + banana + ")");
    }
}
