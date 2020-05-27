package xin.sunce.chapter5.pattern.action.strategy;

/**
 * 具体方案
 *
 * @author lowrie
 * @date 2019-08-29
 */
public class Content {

    private Strategy strategy;


    public Content(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.goHome();
    }
}
