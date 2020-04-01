package xin.sunce.chapter5.pattern.singleton;

/**
 * 静态内部类
 * 这种写法也是effective java 推荐的
 */
public class Singleton6 {

    /**
     * 私有无参数构造器
     */
    private Singleton6() {
        if (null != SingletonHolder.INSTANCE) {
            throw new RuntimeException();
        }
    }

    /**
     * 私有静态内部类，只有getInstance可以访问它，因此它是懒汉式
     * <p>
     * 没有同步访问限制，所以没有性能缺陷，不依赖JDK版本
     */
    private static class SingletonHolder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public Singleton6 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
