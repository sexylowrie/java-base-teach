package xin.sunce.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 *
 * @author lowrie
 */
public class DynamicPayProxy implements InvocationHandler {

    private Object object;

    private DynamicPayProxy() {
    }

    public DynamicPayProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理类");
        method.invoke(object, args);
        return null;
    }
}
