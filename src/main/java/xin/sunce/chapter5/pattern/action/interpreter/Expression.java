package xin.sunce.chapter5.pattern.action.interpreter;

import java.util.Map;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 表达式
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public interface Expression {

    boolean interpreter(Map<String, Long> state);
}
