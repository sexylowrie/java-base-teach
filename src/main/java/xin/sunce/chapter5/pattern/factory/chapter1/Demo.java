package xin.sunce.chapter5.pattern.factory.chapter1;

import xin.sunce.chapter5.pattern.factory.Car;

/**
 * 简单工厂运行demo
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class Demo {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car jeep = factory.getCar("Jeep");
        System.out.println(jeep.getName());
        Car truck = factory.getCar("Truck");
        System.out.println(truck.getName());
        Car cooper = factory.getCar("Cooper");
        System.out.println(cooper.getName());
    }
}
