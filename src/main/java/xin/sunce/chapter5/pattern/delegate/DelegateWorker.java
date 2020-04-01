package xin.sunce.chapter5.pattern.delegate;

/**
 * 委派者
 *
 * @author lowrie
 * @date 2019-07-28
 */
public class DelegateWorker implements Worker {

    private Worker worker;

    public DelegateWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void doWork() {
        System.out.print("Hi Boss,");
        worker.doWork();
    }
}
