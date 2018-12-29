package xin.sunce.base.chapter5;

import java.util.Arrays;

/**
 * 数组
 */
public class ArrayDemo2 {

    public static void main(String[] args) {
        int[] intArray = new int[4];
        int[] intArr;
        intArr = intArray;
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[3] = 3;
        System.out.println(intArr[0] + "," + intArray[0]);
        System.out.println(intArr[1] + "," + intArray[1]);
        System.out.println(intArr[2] + "," + intArray[2]);
        System.out.println(intArr[3] + "," + intArray[3]);

        int[] src = {1, 2, 3};
        int[] target = new int[src.length + 1];
        System.arraycopy(src, 0, target, 0, 3);

        src = Arrays.copyOf(src, 10);
    }
}
