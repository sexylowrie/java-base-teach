package xin.sunce.pattern.delegate;

/**
 * @author lowrie
 * @date 2019-07-28
 */
public class BossDemo {

    public static void main(String[] args) {
        Worker delegate = new DelegateWorker(new OriginalWorker());
        delegate.doWork();
    }
}
