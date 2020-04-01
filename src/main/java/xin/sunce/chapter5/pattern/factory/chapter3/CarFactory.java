package xin.sunce.chapter5.pattern.factory.chapter3;

import xin.sunce.chapter5.pattern.factory.Car;

/**
 * 抽取工厂类：生产一系列相关产品
 *
 * @author lowrie
 * @date 2019-07-15
 */
public interface CarFactory {


    /**
     * 生产车窗
     *
     * @return 返回车窗
     */
    Window createWindow();

    /**
     * 生产车
     *
     * @return 返回车
     */
    Car createCar();


}
