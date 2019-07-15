package xin.sunce.pattern.factory.chapter3;

import xin.sunce.pattern.factory.Car;
import xin.sunce.pattern.factory.Truck;

/**
 * Truck工厂类
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class TruckFactory implements CarFactory {

    @Override
    public Window createWindow() {
        return new BigWindow();
    }

    @Override
    public Car createCar() {
        return new Truck();
    }
}
