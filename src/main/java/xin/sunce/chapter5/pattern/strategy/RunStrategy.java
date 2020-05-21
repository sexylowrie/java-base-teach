package xin.sunce.chapter5.pattern.strategy;

/**
 * 跑步回家策略
 *
 * @author lowrie
 * @date 2019-08-29
 */
//NewUpStrategy使用
@StrategyAnnotation
public class RunStrategy implements Strategy {

    @Override
    public void goHome() {
        System.out.println("I will go home by run.");
    }
}
