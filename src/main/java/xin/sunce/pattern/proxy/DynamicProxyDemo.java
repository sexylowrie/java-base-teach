package xin.sunce.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理模式示例
 * jdk动态代理
 *
 * @author lowrie
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        PayInterface payInterface = new PayImpl();
        InvocationHandler invocationHandler = new DynamicPayProxy(payInterface);
        Class clazz = payInterface.getClass();
        PayInterface payInstance = (PayInterface) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler);
        payInstance.pay();
    }
}
