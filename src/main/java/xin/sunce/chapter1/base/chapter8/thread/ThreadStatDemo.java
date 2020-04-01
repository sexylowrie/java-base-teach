package xin.sunce.chapter1.base.chapter8.thread;

/**
 * 线程状态 示例
 */
public class ThreadStatDemo {

    public static void main(String[] args) {
        runnable();
    }


    /**
     * Runnable状态
     */
    private static void runnable() {
        int i = 0;
        while (true) {
            i++;
            if (i == 10) {
                i = 0;
            }
        }
    }

    /**
     * WAITING 状态
     */
    private static void waiting() {
        Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }

    }

    /**
     * TIMED_WAITING 状态
     */
    private static void timedWaiting() {
        Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(100000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    /**
     * BLOCKED 状态
     */
    private static void blocked() {
        final Object lock = new Object();
        new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("i got lock, but don't release");
                    try {
                        Thread.sleep(1000L * 1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        synchronized (lock) {
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
