package xin.sunce.chapter5.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例之饿汉式升级 防止反序列化
 */
public class Singleton7 implements Serializable {

    /**
     * 私有化无参数构造器
     */
    private Singleton7() {
    }

    /**
     * 饿汉式可以声明final类型
     */
    private static final Singleton7 INSTANCE = new Singleton7();

    /**
     * 声明称静态方法
     */
    public static Singleton7 getInstance() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

}
