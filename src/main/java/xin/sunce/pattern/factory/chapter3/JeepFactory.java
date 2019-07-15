package xin.sunce.pattern.factory.chapter3;

import xin.sunce.pattern.factory.Car;
import xin.sunce.pattern.factory.Jeep;

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
