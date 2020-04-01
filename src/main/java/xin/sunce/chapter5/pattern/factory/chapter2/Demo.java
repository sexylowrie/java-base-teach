package xin.sunce.chapter5.pattern.factory.chapter2;

import xin.sunce.chapter5.pattern.factory.Car;

/**
 * 工厂方法模式演示demo
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class Demo {

    public static void main(String[] args) {
        CarFactory jeepFactory = new JeepFactory();
        Car jeep = jeepFactory.getCar();
        System.out.println(jeep.getName());
        TruckFactory truckFactory = new TruckFactory();
        Car truck = truckFactory.getCar();
        System.out.println(truck.getName());
        CooperFactory cooperFactory = new CooperFactory();
        Car cooper = cooperFactory.getCar();
        System.out.println(cooper.getName());

    }
}
