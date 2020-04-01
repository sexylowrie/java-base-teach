package xin.sunce.chapter5.pattern.factory.chapter1;

import xin.sunce.chapter5.pattern.factory.Cooper;
import xin.sunce.chapter5.pattern.factory.Car;
import xin.sunce.chapter5.pattern.factory.Jeep;
import xin.sunce.chapter5.pattern.factory.Truck;

/**
 * 简单工厂
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class CarFactory {

    public Car getCar(String name) {
        switch (name) {
            case "Jeep":
                return new Jeep();
            case "Truck":
                return new Truck();
            case "Cooper":
                return new Cooper();
            default:
                throw new RuntimeException(String.format("Not Support Car Type: %s", name));
        }
    }
}
