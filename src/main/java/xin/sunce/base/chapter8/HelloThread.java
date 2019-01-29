package xin.sunce.base.chapter8;

/**
 * 声明并启动方式一
 */
public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("start demo 1");
    }

    public static void main(String[] args) {
        new HelloThread().start();
    }
}
