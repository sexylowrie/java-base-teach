package xin.sunce.chapter8.leetcode;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 206. 反转链表
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-23
 */
public class Solution206 {


    /**
     * 递归解法，解题过程看输出语句
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            System.out.println("中间过程：" + head + ",地址值：" + head.hashCode());
            System.out.println("开始出栈：" + head + ",地址值：" + head.hashCode());
            return head;
        }
        ListNode next = head.next;
        System.out.println("中间过程：" + head + ",地址值：" + head.hashCode());
        ListNode newHead = reverseList(next);
        System.out.println("中间过程head：" + head + ",地址值：" + head.hashCode());
        System.out.println("中间过程next初始：" + next + ",地址值：" + next.hashCode());
        System.out.println("中间过程newHead初始：" + newHead + ",地址值：" + newHead.hashCode());
        next.next = head;
        head.next = null;
        System.out.println("中间过程next最终：" + next + ",地址值：" + next.hashCode());
        System.out.println("中间过程newHead最终：" + newHead + ",地址值：" + newHead.hashCode());
        return newHead;
    }

    /**
     * 遍历解法：reverseList
     * <p>
     * 思路：当前节点的next指向pre，然后指针下移，当前节点赋值给pre，当前节点的next赋值给当前节点，以次循环；
     * 注意点：需要把当前节点的next提前保存一下
     */
    public ListNode reverseList1(ListNode head) {
        ListNode current = head, pre = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution206 solution = new Solution206();
        System.out.println("遍历解法：");
        System.out.println(head);
        ListNode pre = solution.reverseList1(head);
        System.out.println(pre);
        System.out.println("递归解法：");
        System.out.println(pre);
        System.out.println("地址值：" + pre.next.next.next.next.hashCode());
        pre = solution.reverseList(pre);
        System.out.println(pre);

    }
}


