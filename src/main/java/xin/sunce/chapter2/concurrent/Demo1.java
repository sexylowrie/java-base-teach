package xin.sunce.chapter2.concurrent;

/**
 * 同步测试
 *
 * @author lowrie
 * @date 2019-09-03
 */
public class Demo1 {

    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        };


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("x = [" + x + "]" + ", y =[" + y + "] ");
    }
}
