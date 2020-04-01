package xin.sunce.chapter1.base.chapter8.thread;

public class StartRunDemo {

    public static void main(String[] args) {
        Temp temp = new Temp();
        temp.run();
        temp.start();

    }

    static class Temp extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": hello。");
        }
    }
}
