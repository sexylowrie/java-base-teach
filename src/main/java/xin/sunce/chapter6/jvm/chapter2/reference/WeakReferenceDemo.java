package xin.sunce.chapter6.jvm.chapter2.reference;

import java.lang.ref.WeakReference;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-01
 */
public class WeakReferenceDemo {

    /**
     * 弱引用相比软引用还要弱一些，只要GC就会回收
     */
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o = null;
        System.gc();
        System.out.println("=========================");
        System.out.println(o);
        System.out.println(softReference.get());
    }
}
