package xin.sunce.chapter8.leetcode;

import java.util.StringJoiner;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-23
 */
public class ListNode {

    int val;
    xin.sunce.chapter8.leetcode.ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return new StringJoiner("->")
                .add(val + "")
                .add(next + "")
                .toString();
    }
}
