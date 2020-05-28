package xin.sunce.chapter5.pattern.action.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 访问者模式演示类
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class Demo {


    public static void main(String[] args) {
        List<Data> list = getData();
        Finder finder = new Finder();
        for (Data data : list) {
            finder.visit(data);
        }

        Replacer replacer = new Replacer();
        for (Data data : list) {
            replacer.visit(data);
        }
    }


    private static List<Data> getData() {
        List<Data> data = new ArrayList<>();
        data.add(new Txt("你好"));
        data.add(new Word("Hello"));
        return data;
    }
}
