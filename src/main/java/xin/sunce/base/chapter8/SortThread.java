package xin.sunce.base.chapter8;

/**
 * 排序线程执行顺序T1,T2,T3
 */
public class SortThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("thread 1"));
        Thread t2 = new Thread(() -> System.out.println("thread 2"));
        Thread t3 = new Thread(() -> System.out.println("thread 3"));

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
