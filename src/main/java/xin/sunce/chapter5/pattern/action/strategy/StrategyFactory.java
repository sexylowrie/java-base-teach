package xin.sunce.chapter5.pattern.action.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式配合工厂使用
 * <p>
 * 缓存策略模式实现一：单例
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put(TypeConstant.RUN, new RunStrategy());
        strategies.put(TypeConstant.TRAIN, new TrainStrategy());
        strategies.put(TypeConstant.TAXI, new TaxiStrategy());
    }

    public static Strategy createStrategy(String type) {
        return strategies.get(type);
    }

}
