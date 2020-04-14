package xin.sunce.chapter7.algorithm.exception;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-14
 */
public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next==2){
                list.remove(next);
            }
        };
    }
}
