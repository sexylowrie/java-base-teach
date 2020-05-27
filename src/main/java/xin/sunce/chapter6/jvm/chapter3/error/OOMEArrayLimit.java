package xin.sunce.chapter6.jvm.chapter3.error;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 * <p>
 * 数组限制
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class OOMEArrayLimit {

    /**
     * java.lang.OutOfMemoryError: Requested array size exceeds VM limit
     */
    public static void main(String[] args) {
        int[] intArray2 = new int[Integer.MAX_VALUE - 1];
        System.out.println("create array2:" + (Integer.MAX_VALUE - 1));
        int[] intArray3 = new int[Integer.MAX_VALUE];
        System.out.println("create array0:" + (Integer.MAX_VALUE - 0));
    }
}
