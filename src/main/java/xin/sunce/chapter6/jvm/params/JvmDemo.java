package xin.sunce.chapter6.jvm.params;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-03-31
 */
public class JvmDemo {


    public static void main(String[] args) throws Exception {
        System.out.println("Hello GC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
