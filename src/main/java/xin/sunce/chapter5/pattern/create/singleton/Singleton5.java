package xin.sunce.chapter5.pattern.create.singleton;

/**
 * 单例之懒汉式升级三
 */
public class Singleton5 {

    /**
     * 私有化无参数构造器
     */
    private Singleton5() {
    }

    /**
     * 声明为volatile 可以防止JVM指令重排
     */
    private static volatile Singleton5 instance;

    /**
     * 声明为静态方法，实现懒加载
     * synchronized关键字添加到 instance = new Singleton4(); 之上
     */
    public static Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }


}
