package xin.sunce.chapter5.pattern.singleton;

/**
 * 单例之懒汉式
 */
public class Singleton2 {

    /**
     * 私有化无参数构造器
     */
    private Singleton2() {
    }

    private static Singleton2 instance;

    /**
     * 声明为静态方法，实现懒加载
     */
    public static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
