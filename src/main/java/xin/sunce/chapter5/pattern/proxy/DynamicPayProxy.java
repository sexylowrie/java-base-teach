package xin.sunce.chapter5.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author lowrie
 */
public class DynamicPayProxy implements InvocationHandler {

    /**目标对象*/
    private Object target;


    /**获取代理对象实例*/
    public Object newProxyInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**方法调用*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理类");
        Object invoke = null;
        try {
            invoke = method.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoke;
    }
}
