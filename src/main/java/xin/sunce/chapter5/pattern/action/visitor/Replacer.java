package xin.sunce.chapter5.pattern.action.visitor;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class Replacer implements Visitor {

    @Override
    public void visit(Data data) {
        System.out.println("replace data:" + data.content().replace("I am", "You are"));
    }
}
