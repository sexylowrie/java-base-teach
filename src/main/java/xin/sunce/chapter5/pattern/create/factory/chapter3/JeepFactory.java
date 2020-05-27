package xin.sunce.chapter5.pattern.create.factory.chapter3;

import xin.sunce.chapter5.pattern.create.factory.Car;
import xin.sunce.chapter5.pattern.create.factory.Jeep;

/**
 * Jeep工厂类
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class JeepFactory implements CarFactory {

    @Override
    public Window createWindow() {
        return new MidWindow();
    }

    @Override
    public Car createCar() {
        return new Jeep();
    }
}
