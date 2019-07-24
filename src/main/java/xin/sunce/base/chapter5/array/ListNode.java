package xin.sunce.base.chapter5.array;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultPre = new ListNode(0);
        ListNode a = l1, b = l2, temp = resultPre;
        int high = 0;
        while (null != a || null != b) {
            int aVal = (a == null) ? 0 : a.val;
            int bVal = (b == null) ? 0 : b.val;
            int sum = high + aVal + bVal;
            //进位
            high = sum / 10;
            int rVal = sum % 10;
            //赋值
            temp.next = new ListNode(rVal);
            temp = temp.next;
            if (null != a) a = a.next;
            if (null != b) b = b.next;
        }
        //易错点,最后一位进位
        if (high > 0) {
            temp.next = new ListNode(high);
        }
        return resultPre.next;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals(null) || s.equals("")) {
            return 0;
        }
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                StringBuilder builder = new StringBuilder(s.substring(i, j));
                String temp = builder.toString();
                String lit = s.substring(j, j + 1);
                if (!temp.contains(lit)) {
                    builder.append(lit);
                    max = (builder.length() > max) ? builder.length() : max;
                    System.out.println(builder.toString());
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(6);
//        l1.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(2);
//        ListNode listNode = Solution.addTwoNumbers(l1, l2);
//        while (null != listNode) {
//            System.out.print(listNode.val);
//            if (null != listNode) {
//                listNode = listNode.next;
//            }
//        }

        int max = lengthOfLongestSubstring("abcabcbb");
        System.out.println(max);
    }
}

