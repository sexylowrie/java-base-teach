package xin.sunce.pattern.factory.chapter2;

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
    public Car getCar() {
        return new Jeep();
    }
}
