package xin.sunce.chapter2.concurrent;

/**
 * -XX:+TraceClassLoading
 *
 * @author lowrie
 * @date 2019-09-03
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        testDemo1();
//        testDemo2();
    }


    /**
     * 可能结果:
     * x = [1], y =[0]
     * x = [0], y =[1]
     * x = [1], y =[1]
     * x = [0], y =[0]
     *
     * @throws InterruptedException
     */
    static void testDemo1() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Demo1.a = 1;
                Demo1.x = Demo1.b;
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Demo1.b = 1;
                Demo1.y = Demo1.a;
            }
        };


        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        System.out.println("x = [" + Demo1.x + "]" + ", y =[" + Demo1.y + "] ");
    }


    static void testDemo2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Demo2.writer();
            System.out.println(Demo2.d.x);
            System.out.println(Demo2.d.y);
        });

        Thread t2 = new Thread(() -> {
            Demo2.reader();
        });

        t1.start();
        t2.start();
    }
}
