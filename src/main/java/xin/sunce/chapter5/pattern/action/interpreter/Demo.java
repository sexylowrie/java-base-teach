package xin.sunce.chapter5.pattern.action.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 解释器模式演示类
 * <p>
 * <p>
 * 场景描述：假设要你实现一个规则引擎，具体的规则包括 && ，> ，<
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Demo {


    public static void main(String[] args) {
        Map<String, Long> params = new HashMap<>();
        params.put("key1", 101L);
        params.put("key2", 90L);
//        params.put("key3",90L);
        String expression = "key1>100&key2<200&key3>400";
        AndExpression and = new AndExpression(expression);
        boolean result = and.interpreter(params);
        System.out.println(params.toString() + ":" + result);
    }
}
