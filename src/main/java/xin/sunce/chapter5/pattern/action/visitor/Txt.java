package xin.sunce.chapter5.pattern.action.visitor;

import java.util.StringJoiner;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class Txt implements Data {


    private String context;

    public Txt(String context) {
        this.context = context;
    }

    @Override
    public String content() {
        return "I am txt, content:" + context;
    }

}
