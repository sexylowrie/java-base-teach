package xin.sunce.pattern.delegate;

/**
 * 源员工
 *
 * @author lowrie
 * @date 2019-07-28
 */
public class OriginalWorker implements Worker {

    @Override
    public void doWork() {
        System.out.println("I am working very hard.");
    }
}
