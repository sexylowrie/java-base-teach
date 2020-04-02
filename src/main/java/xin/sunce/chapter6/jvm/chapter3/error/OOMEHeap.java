package xin.sunce.chapter6.jvm.chapter3.error;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 堆内存溢出模拟
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMEHeap {

    /**
     * 启动参数：
     * -Xms1m -Xmx1m
     * java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[2 * 1024 * 1024];
    }
}
