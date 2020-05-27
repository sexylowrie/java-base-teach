package xin.sunce.chapter6.jvm.chapter3.error;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 * <p>
 * 无法创建更多的本地线程
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMENativeThread {

    /**
     * java.lang.OutOfMemoryError: unable to create new native thread
     */
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i += 1;
                Thread thread = new Thread();
                thread.start();
            }
        } catch (Throwable e) {
            System.out.println("nums: " + i);
            e.printStackTrace();
        }

    }
}
