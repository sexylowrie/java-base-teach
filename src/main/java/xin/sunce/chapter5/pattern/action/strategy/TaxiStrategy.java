package xin.sunce.chapter5.pattern.action.strategy;

/**
 * 跑步回家策略
 *
 * @author lowrie
 * @date 2019-08-29
 */
public class TaxiStrategy implements Strategy {

    @Override
    public void goHome() {
        System.out.println("I will go home by taxi.");
    }
}
