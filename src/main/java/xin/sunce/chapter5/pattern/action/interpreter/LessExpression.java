package xin.sunce.chapter5.pattern.action.interpreter;

import java.util.Map;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 小于表达式
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class LessExpression implements Expression {

    private String key;
    private long value;

    public LessExpression(String expression) {
        String[] elements = expression.trim().split("\\<");
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[1].trim());
    }

    @Override
    public boolean interpreter(Map<String, Long> state) {
        if (!state.containsKey(key)) {
            return false;
        }
        Long stateValue = state.get(key);
        return stateValue < value;

    }
}
