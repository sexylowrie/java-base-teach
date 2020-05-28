package xin.sunce.chapter5.pattern.action.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 与表达式
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class AndExpression implements Expression {

    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String expression) {
        String[] elements = expression.trim().split("\\&");
        for (String element : elements) {
            if (element.contains("<")) {
                expressions.add(new LessExpression(element));
            } else if (element.contains(">")) {
                expressions.add(new GreaterExpression(element));
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override
    public boolean interpreter(Map<String, Long> state) {
        for (Expression expression : expressions) {
            if (!expression.interpreter(state)) {
                return false;
            }
        }
        return true;
    }
}
