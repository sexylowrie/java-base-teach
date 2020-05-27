package xin.sunce.chapter5.pattern.create.singleton;

/**
 * 单例之饿汉式
 */
public class Singleton1 {

    /**
     * 私有化无参数构造器
     */
    private Singleton1() {
    }

    /**
     * 饿汉式可以声明final类型
     */
    private static final Singleton1 instance = new Singleton1();

    /**
     * 声明称静态方法
     */
    public static Singleton1 getInstance() {
        return instance;
    }
}
