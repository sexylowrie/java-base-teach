package xin.sunce.chapter5.pattern.action.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 迭代器演示Demo
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class Demo {

    public static void main(String[] args) {
        int target = 6;
        MyArrayList my = new MyArrayList();
        my.add(1);
        my.add(2);
        my.add(3);
        my.add(4);
        my.add(5);
        my.add(6);
        Iterator iterator = my.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals(target)) {
                //my.remove(i);//运行时报错
                iterator.remove();
            }

            i++;
        }

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Iterator it = list.iterator();
        int j = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (next.equals(target)) {
                //list.remove(j);//运行时报错
                it.remove();
            }
            j++;
        }
    }
}
