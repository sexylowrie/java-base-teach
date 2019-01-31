package xin.sunce.pattern.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * reflect解决方案
 */
public class SingletonReflect implements Serializable {

    /**
     * 私有化构造函数
     */
    private SingletonReflect() {
        if (null != SingletonHolder.INSTANCE) {
            throw new RuntimeException();
        }
    }

    /**
     * 声明公有的 获取实例方法
     */
    public static SingletonReflect getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 私有内部静态类
     */
    private static class SingletonHolder {

        private static final SingletonReflect INSTANCE = new SingletonReflect();

    }

    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        try {
            SingletonReflect instance = SingletonReflect.getInstance();
            Class clazz = Class.forName("xin.sunce.pattern.singleton.SingletonReflect");
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            SingletonReflect instance2 = (SingletonReflect) constructor.newInstance();

            System.out.println("instance 与 instance2 是同一个实例: " + (instance == instance2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}