package xin.sunce.chapter5.pattern.create.factory.chapter3;

import xin.sunce.chapter5.pattern.create.factory.Car;

/**
 * 抽象工厂演示类
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class Demo {

    public static void main(String[] args) {
        CarFactory jeepFactory = new JeepFactory();
        Window jeepWindow = jeepFactory.createWindow();
        System.out.println(jeepWindow.getModel());
        Car jeepCar = jeepFactory.createCar();
        System.out.println(jeepCar.getName());

        CarFactory truckFactory = new TruckFactory();
        Window truckWindow = truckFactory.createWindow();
        System.out.println(truckWindow.getModel());
        Car truckCar = truckFactory.createCar();
        System.out.println(truckCar.getName());

    }
}
