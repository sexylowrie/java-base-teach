package xin.sunce.base.chapter5;

import com.sun.tools.javac.util.Assert;

import java.util.Random;

public class ArrayMath {


    /**
     * 传入数组大小生成随机数组
     *
     * @param size 数组大小
     * @return int[] 随机int数组
     */
    public static int[] getNums(int size) {
        if (size <= 0) {
            return null;
        }
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(100);
        }
        return result;
    }

    /**
     * 数组冒泡排序算法实现：从小到大
     * 算法简述：两两比较，如果i>i+1交互位置；循环往复直到排序完成;
     *
     * @param source 待排序数组
     */
    public static void bubbleSort(int[] source) {
        Assert.checkNonNull(source);
        int length = source.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (source[j] >= source[j + 1]) {
                    temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
            System.out.print(i + ":");
            printResult(source);
        }
    }

    /**
     * 插入排序实现：从小到大
     * 算法简述：假如有数组已经完成排序，当一个数字n需要插入时，从队尾开始向队首比较插入；如果比队尾大则直接插入队尾，否则换位再向前比较
     *
     * @param source 待排序数组
     */
    public static void insertSort(int[] source) {
        Assert.checkNonNull(source);
        int length = source.length;
        int temp;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (source[j + 1] < source[j]) {
                    temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
            System.out.print(i + ":");
            printResult(source);
        }
    }


    /**
     * 快速排序
     * 算法简述：从数组中取中间位数据作为参考数index，
     * 遍历index左边的数据比较与index的大小，比index大的数字放置于其右边；
     * 遍历index右边的数据比较与index的大小，比index小的数字放置于其左边。
     *
     * @param source 待排序数组
     * @param begin  头
     * @param end    尾
     */
    public static void quickSort(int[] source, int begin, int end) {
        if (null == source || source.length <= 1 || begin >= end) {
            return;
        }
        int left = begin, right = end, index = source[(begin + end) / 2];
        do {
            while (source[left] < index) {
                left++;
            }
            while (source[right] > index) {
                right--;
            }
            if (right > left) {
                int temp = source[right];
                source[right] = source[left];
                source[left] = temp;
                left++;
                right--;
            } else if (right == left) {
                left++;
            }
        } while (right >= left);
        quickSort(source, begin, right);
        quickSort(source, left, end);
        printResult(source);
    }

    /**
     * 输出结果
     *
     * @param nums 数组大小
     */
    public static void printResult(int[] nums) {
        if (null == nums || 0 == nums.length) {
            System.out.println();
        }
        int length = nums.length;
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < length; i++) {
            if (length - 1 != i) {
                builder.append(nums[i]).append(",");
            } else {
                builder.append(nums[i]).append("}");
                System.out.println(builder.toString());
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = getNums(9);
        printResult(nums);
        int length = nums.length;
        int[] bubble = new int[length];
        System.arraycopy(nums, 0, bubble, 0, length);
        System.out.println("bubble sort result:");
        bubbleSort(bubble);
        int[] insert = new int[length];
        System.arraycopy(nums, 0, insert, 0, length);
        System.out.println("insert sort result:");
        insertSort(insert);
        int[] quick = new int[length];
        System.arraycopy(nums, 0, quick, 0, length);
        System.out.println("quick sort result:");
        quickSort(quick, 0, quick.length - 1);
    }


}
