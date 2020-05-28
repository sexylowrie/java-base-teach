package xin.sunce.chapter5.pattern.action.mediator;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 中介模式演示类
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Demo {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Airplane airplane1 = new Airplane("SN001", false);
        Airplane airplane2 = new Airplane("SN002", false);
        Airplane airplane3 = new Airplane("SN003", false);
        Airplane airplane4 = new Airplane("SN004", true);
        mediator.register(airplane1);
        mediator.register(airplane2);
        mediator.register(airplane3);
        mediator.register(airplane4);
        boolean result = airplane4.request(mediator);
        System.out.println(airplane4.getId() + " request:" + result);
    }

}
