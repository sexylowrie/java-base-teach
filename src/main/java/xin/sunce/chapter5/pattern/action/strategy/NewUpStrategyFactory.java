package xin.sunce.chapter5.pattern.action.strategy;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 升级策略模式配合工厂使用
 * <p>
 * 非单例
 * <p>
 */
public class NewUpStrategyFactory {

    private static final Map<String, Class> strategies = new HashMap<>();

    static {
        strategies.put(TypeConstant.RUN, RunStrategy.class);
        strategies.put(TypeConstant.TRAIN, TrainStrategy.class);
        strategies.put(TypeConstant.TAXI, TaxiStrategy.class);
    }


    public static Strategy createStrategy(String type) throws Exception {
        Class clazz = strategies.get(type);
        if (clazz != null) {
            Constructor a = clazz.getConstructor();
            return (Strategy) a.newInstance();
        }
        return null;
    }

}
