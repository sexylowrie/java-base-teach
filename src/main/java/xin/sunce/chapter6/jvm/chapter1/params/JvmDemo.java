package xin.sunce.chapter6.jvm.chapter1.params;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-03-31
 */
public class JvmDemo {

    /**
     * -Xmx == -XX:MaxHeapSize 默认物理内存1/4
     * -Xms == -XX:InitialHeapSize  默认物理内存1/64 一般简单优化会把-Xmx与-Xms调整成一样的
     * <p>
     * -Xmn == -XX:NewSizes
     * -Xss == -XX:ThreadStackSize 默认物理1024k
     * -XX:MetaspaceSize 设置元空间大小
     * -XX:MaxMetaspaceSize 设置最大元空间大小
     * -XX:SurvivorRatio 默认8，Eden:S0:S1=8:1:1
     * -XX:NewRatio 默认2，Old:New =2:1
     * -XX:MaxtenuringThreshold  默认15，一个对象经历15次GC之后还存活则进入老年代
     * -XX:PrintGCDetails 输出GC细节
     * -XX:+PrintFlagsInitial 输出默认参数
     * -XX:+PrintFlagsFinal 输出修改后参数
     * -XX:+PrintCommandLineFlags 输出GC Collector相关参数
     * <p>
     * 如何查看正在运行的java应用参数配置
     * 首先：jps 获取java进程号
     * 其次：jinfo -flag 参数名 进程号  例如：jinfo -flag MaxHeapSize 27981
     * 或者：jinfo -flags  xxx
     * <p>
     * 或者启动时输出
     * -XX:+PrintFlagsInitial 输出默认参数
     * -XX:+PrintFlagsFinal 输出修改后参数
     * -XX:+PrintCommandLineFlags 输出GC Collector相关参数
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello GC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
