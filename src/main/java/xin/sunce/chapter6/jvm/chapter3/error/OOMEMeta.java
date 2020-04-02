package xin.sunce.chapter6.jvm.chapter3.error;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 元空间内存溢出模拟
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMEMeta {


    public static class Test {
    }

    /**
     * 启动参数：
     * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
     * java.lang.OutOfMemoryError: Metaspace
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Test.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }
}
