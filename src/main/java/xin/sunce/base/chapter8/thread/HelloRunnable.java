package xin.sunce.base.chapter8.thread;

/**
 * 声明并启动方式二
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("start demo 2");
    }

    public static void main(String[] args) {
        new Thread(new HelloRunnable()).start();
    }
}
