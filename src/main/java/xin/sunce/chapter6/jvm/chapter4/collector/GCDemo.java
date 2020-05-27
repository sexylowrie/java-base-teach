package xin.sunce.chapter6.jvm.chapter4.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 * GC 演示
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-03
 */
public class GCDemo {

    /**
     * 启动参数：
     * 1.Serial
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseSerialGC
     * 2.ParNew
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseParNewGC
     * 3.Parallel
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseParallelGC
     * 4.ParallelOld
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseParallelOldGC
     * 5.CMS
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
     * 6.G1
     * -Xms4m -Xmx4m -XX:+PrintGCDetails -XX:+UseG1GC
     * <p>
     * DefNew 表示：新生代Serial
     * Tenured 表示：老年代SerialOld
     * ParNew 表示：新生代ParNew
     * PSYoungGen 表示：新生代Parallel Scavenge
     * ParOldGen 表示：老年代Parallel
     * CMS 表示：老年代ConcMarkSweep
     * G1 表示：G1
     */
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>();
            while (true) {
                list.add("hello GC" + new Random().nextInt(999999999) + new Random().nextInt(888888888));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
