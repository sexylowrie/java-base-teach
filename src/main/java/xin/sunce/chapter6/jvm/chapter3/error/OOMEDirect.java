package xin.sunce.chapter6.jvm.chapter3.error;

import java.nio.ByteBuffer;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 * <p>
 * 直接内存
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMEDirect {

    /**
     * 启动参数：
     * -XX:MaxDirectMemorySize=10m
     * java.lang.OutOfMemoryError: Direct buffer memory
     */
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(20 * 1024 * 1024);
    }
}
