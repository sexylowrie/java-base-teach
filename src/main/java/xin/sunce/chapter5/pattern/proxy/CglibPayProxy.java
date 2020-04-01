package xin.sunce.chapter5.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 代理
 *
 * @author lowrie
 */
public class CglibPayProxy implements MethodInterceptor {


    /**
     * 构建代理对象
     */
    public Object newProxyInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入cglib代理类");
        return methodProxy.invokeSuper(o, objects);
    }
}
