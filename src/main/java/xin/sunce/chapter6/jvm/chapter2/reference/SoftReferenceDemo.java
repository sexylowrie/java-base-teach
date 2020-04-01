package xin.sunce.chapter6.jvm.chapter2.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用Demo
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-01
 */
public class SoftReferenceDemo {

    /**
     * 添加启动参数 -Xmx1m -Xms1m -XX:+PrintGCDetails
     * 执行enough(),内存充足时软引用不会被回收
     * 执行noenough(),限制启动此参数,故意分配大内存,导致OOME,软引用自动回收
     */
    public static void main(String[] args) {
//        enough();
        noenough();
    }

    private static void noenough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o = null;
        try {
            byte[] bytes = new byte[2 * 1024 * 1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("=========================");
            System.out.println(o);
            System.out.println(softReference.get());
        }

    }

    private static void enough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o = null;
        System.gc();
        System.out.println("=========================");
        System.out.println(o);
        System.out.println(softReference.get());
    }
}
