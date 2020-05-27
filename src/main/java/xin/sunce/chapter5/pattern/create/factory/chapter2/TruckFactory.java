package xin.sunce.chapter5.pattern.create.factory.chapter2;

import xin.sunce.chapter5.pattern.create.factory.Car;
import xin.sunce.chapter5.pattern.create.factory.Truck;

/**
 * Truck工厂类
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class TruckFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new Truck();
    }
}
