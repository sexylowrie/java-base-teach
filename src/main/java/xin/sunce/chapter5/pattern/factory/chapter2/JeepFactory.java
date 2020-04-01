package xin.sunce.chapter5.pattern.factory.chapter2;

import xin.sunce.chapter5.pattern.factory.Car;
import xin.sunce.chapter5.pattern.factory.Jeep;

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
