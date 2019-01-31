package xin.sunce.pattern.singleton;

/**
 * 单例之懒汉式升级二
 */
public class Singleton4 {

    /**
     * 私有化无参数构造器
     */
    private Singleton4() {
    }

    private static Singleton4 instance;

    /**
     * 声明为静态方法，实现懒加载
     * synchronized关键字添加到 instance = new Singleton4(); 之上
     * 此方法的缺陷是 instance = new Singleton();不是原子操作
     * instance = new Singleton4(); 实际上JVM做了三件事情
     * 1.给instance 分配内存
     * 2.调用instance 构造函数
     * 3.将instance指向分配的内存空间 instance则不为空
     * 其中1，2，3的执行步骤不能保证顺序性，可能的执行顺序为1，2，3/1，3，2
     * JVM为了提高CPU的使用效率，会有指令重排的情况发生；可能重排为1，3，2的执行顺序
     */
    public static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                instance = new Singleton4();
            }
        }
        return instance;
    }


}
