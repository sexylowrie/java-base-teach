package xin.sunce.base.chapter8.thread;

import java.util.HashMap;
import java.util.Map;

public class Math {
    static Map<Character, Integer> BASE = new HashMap<>();
    static Map<Character, String> SUB = new HashMap<>();

    static {
        BASE.put('I', 1);
        BASE.put('V', 5);
        BASE.put('X', 10);
        BASE.put('L', 50);
        BASE.put('C', 100);
        BASE.put('D', 500);
        BASE.put('M', 1000);
        SUB.put('I', "VX");
        SUB.put('X', "LC");
        SUB.put('C', "DM");
    }


    public int romanToInt(String s) {
        char[] params = s.toCharArray();
        if (null == params) {
            throw new IllegalArgumentException("not input empty string");
        }

        int length = params.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            Integer val = BASE.get(params[i]);
            if (null == val) {
                throw new IllegalArgumentException(" input error char" + params[i]);
            }
            int pre = 0, next = 0;
            if (i > 0 && i < length - 1) {
                next = BASE.get(params[i + 1]);
                if (next > val) {
                    if (SUB.get(params[i]).contains(params[i + 1] + "")) {
                        result = -1 * val + result;
                    } else {
                        throw new IllegalArgumentException("error postion");
                    }
                } else {
                    result = val + result;
                }
            }
        }
        return result;
    }

    /**
     * 中位数：表示数组中处于中间位置的数字
     * 元素总数为奇数的话，处于有序数组中间值即为中位数，数组下标位置： (n+1)/2-1=(n-1)/2
     * 元素总数为偶数的话，处于有序数组中间两个数的平均值即为中位数，数组下标位置：n/2,n/2-1
     * 一直保持二分查找法，此题的争议点是有两个有序数组，这两个数组有可能有交集
     * 情况1:
     * [1,2,3]  太小
     * [     (4),5,6,7]
     * <p>
     * <p>
     * 情况2:
     * [1,3,4] 舒适区 num1
     * [  3,4,7,8]   num2
     * <p>
     * 以此为例进行推演： num1->3  3<8  取出4
     * 情况3:
     * [3,      7,  9] 舒适区
     * [ 4,5,(6),8]
     * <p>
     * 情况4:
     * [          5,5,6] 太大
     * [1,2,3,(4)]
     * 循环直至找到结果
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        /**保证n>=m*/
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int mMin = 0, mMax = m, half = (m + n + 1) / 2;
        //固定循环次数用foreach,动态循环次数用while
        while (mMin <= mMax) {
            //扫描次数数 i到j；小集合的中间，到大集合的中间
            int i = (mMin + mMax) / 2;
            int j = half - i;
            if (i < mMax && nums2[j - 1] > nums1[i]) {
                //情况1:太小
                mMin = i + 1;
            } else if (i > mMin && nums1[i - 1] > nums2[j]) {
                //情况2：太大
                mMax = i - 1;
            } else {
                int maxLeft = 0;
                //舒适区
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums2[i - 1];
                } else {
                    maxLeft = java.lang.Math.max(nums2[j - 1], nums1[i - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = java.lang.Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0d;
    }


    public static String longestPalindrome(String s) {
        int length = s.length();
        int limit = (length + 1) / 2;
        String temp, reverse;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= limit; j++) {
                temp = s.substring(j, length - i);
                reverse = new StringBuilder(temp).reverse().toString();
                if (temp.equals(reverse)) {
                    return temp;
                }
                System.out.println("temp = [" + temp + "]");
                temp = s.substring(0 + i, length - j);
                System.out.println("temp2 = [" + temp + "]");
                reverse = new StringBuilder(temp).reverse().toString();
                if (temp.equals(reverse)) {
                    return temp;
                }
            }
        }
        return null;
    }

}
