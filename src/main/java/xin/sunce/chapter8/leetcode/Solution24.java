package xin.sunce.chapter8.leetcode;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-23
 */
public class Solution24 {

    /**
     * 递归解法
     */

    /**
     * 迭代解法
     */
    public ListNode swapPairs(ListNode head) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode pre = tmp;
        while (head != null && head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
            head = node1.next;
        }
        return tmp.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("遍历解法：");
        System.out.println(head);
        Solution24 solution = new Solution24();
        ListNode result = solution.swapPairs(head);
        System.out.println(result);
    }

}
