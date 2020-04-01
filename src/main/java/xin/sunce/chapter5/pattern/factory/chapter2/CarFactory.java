package xin.sunce.chapter5.pattern.factory.chapter2;

import xin.sunce.chapter5.pattern.factory.Car;

/**
 * 工厂方法模式
 *
 * @author lowrie
 * @date 2019-07-15
 */
public interface CarFactory {

    /**
     * 提供由子类实现的工厂方法
     *
     * @return 返回Car
     */
    Car getCar();
}
