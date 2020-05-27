package xin.sunce.chapter5.pattern.create.singleton;

/**
 * 单例之懒汉式升级一
 */
public class Singleton3 {

    /**
     * 私有化无参数构造器
     */
    private Singleton3() {
    }

    private static Singleton3 instance;

    /**
     * 声明为静态方法，实现懒加载
     * 方法体上添加synchronized 关键字，此方式的缺陷是只能单线程访问
     */
    public static synchronized Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return instance;
    }
}
