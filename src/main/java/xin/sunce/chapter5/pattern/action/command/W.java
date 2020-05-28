package xin.sunce.chapter5.pattern.action.command;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class W implements Command {


    //忽略数据组装过程

    @Override
    public void execute() {
        System.out.println("hero using w");
    }
}
