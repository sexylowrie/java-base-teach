package xin.sunce.base.chapter8.thread;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程池示例
 */
public class SelfThreadExecutors {

    private List<Worker> workers;

    private BlockingDeque<Runnable> jobs;

    private int coreSize = 0;

    private int activeSize = 0;

    private volatile boolean flag = true;

    private SelfThreadExecutors() {

    }

    public SelfThreadExecutors(int coreSize) {
        if (coreSize <= 1) {
            throw new RuntimeException(String.format("wrong core size:%d", coreSize));
        }
        this.coreSize = coreSize;
        this.workers = new Vector<>(coreSize);
        this.jobs = new LinkedBlockingDeque<>();
    }


    public void start(Runnable runnable) {
        if (activeSize < coreSize) {
            addThread(runnable);
        } else {
            jobs.add(runnable);
        }
    }

    public void addThread(Runnable runnable) {
        activeSize++;
        jobs.add(runnable);
        Worker worker = new Worker();
        workers.add(worker);
        worker.start();
    }

    class Worker extends Thread {

        @Override
        public void run() {
            while (true && flag) {
                Runnable job = getJob();
                if (null != job) {
                    System.out.println(Thread.currentThread().getName());
                    job.run();
                }
            }
        }


    }

    private Runnable getJob() {
        try {
            return jobs.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SelfThreadExecutors executors = new SelfThreadExecutors(4);
        for (int i = 0; i < 100; i++) {
            final int j = i;
            executors.start(() -> System.out.println("工作内容" + j));

        }
    }

}
