package xin.sunce.pattern.factory.chapter3;

import xin.sunce.pattern.factory.Car;
import xin.sunce.pattern.factory.Cooper;

/**
 * Cooper工厂类
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class CooperFactory implements CarFactory {

    @Override
    public Window createWindow() {
        return new SmallWindow();
    }

    @Override
    public Car createCar() {
        return new Cooper();
    }
}
