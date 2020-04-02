package xin.sunce.chapter6.jvm.chapter3.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * GC效率低下抛出OOME模拟
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMEGCLimit {

    /**
     * 启动参数：
     * -Xms10m -Xmx10m
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(String.valueOf(++i));
            }
        } catch (Throwable e) {
            System.out.println("times: " + i);
            e.printStackTrace();
        }

    }
}
