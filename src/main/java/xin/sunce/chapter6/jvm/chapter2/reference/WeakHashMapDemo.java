package xin.sunce.chapter6.jvm.chapter2.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * WeakHashMap示例
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-01
 */
public class WeakHashMapDemo {

    /**
     * 弱引用在GC时会被回收，故此WeakHashMap的key无效了，在GC时会被回收
     */
    public static void main(String[] args) {
        testHashMap();
        System.out.println("===================");
        testWeakHashMap();
    }


    private static void testHashMap() {
        HashMap<Integer, String> hashMap = new HashMap();
        Integer i = new Integer(1);
        String str = new String("Test HashMap");
        hashMap.put(i, str);
        System.out.println(hashMap);
        i = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
    }

    private static void testWeakHashMap() {
        WeakHashMap<Integer, String> hashMap = new WeakHashMap();
        Integer i = new Integer(1);
        String str = new String("Test WeakHashMap");
        hashMap.put(i, str);
        System.out.println(hashMap);
        i = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
    }
}
