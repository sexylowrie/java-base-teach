package xin.sunce.chapter7.algorithm;

import java.util.Arrays;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 自定义LinkedList
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-14
 * @see java.util.LinkedList
 */
public class MyLinkedList {

    private int size;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }

    private static class Node {
        Object data;
        Node pre;
        Node next;

        public Node(Object data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        return getNode(index).data;
    }

    /**
     * index靠前正序查找，index靠后倒序查找
     * 正序列：0 1 2 3 4 例如：找index=1 ：0，1
     * 倒序列：0 1 2 3 4 例如：找index=3 ：4，3
     *
     * @param index
     * @return
     */
    public Node getNode(int index) {
        if (index < (size >> 1)) {
            Node node = first;
            for (int i = 0; i <= index - 1; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = last;
            for (int i = size - 1; i >= index + 1; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    /**
     * 尾部插入
     * 当前Node的next总是null，因为其本身是last
     * 当前节点的pre为当前的last
     *
     * @param element
     */
    public void add(Object element) {
//        Node node = new Node(element, null, last);逻辑错误
        Node l = last;
        Node node = new Node(element, last, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
//            node.pre = last;逻辑错误
            l.next = node;
        }
        size++;
    }

    /**
     * 中间插入
     * 将前置节点的next指向自己，将后置节点的pre指向自己
     *
     * @param index
     * @param element
     */
    public void add(int index, Object element) {
        rangeCheck(index);
        if (index == size) {
            Node node = new Node(element, last, null);
            last = node;
        } else {
            Node node = getNode(index);
            if (node.equals(first)) {
                Node now = new Node(element, null, first);
                first = now;
            } else {
                Node pre = getNode(index - 1);
                Node now = new Node(element, pre, node);
                pre.next = now;
            }
        }
        size++;
    }

    public void remove(int index) {
        rangeCheck(index);
        Node node = getNode(index);
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        size--;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[size:" + size + ",");
        Node node = null;
        for (int i = 0; i <= size - 1; i++) {
            if (i == 0) {
                node = first;
            } else {
                node = node.next;
            }
            builder.append(node.data);
            if (i == size - 1) {
                builder.append("]");
            } else {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        list.add(0, -1);
        System.out.println(list);
        list.add(list.size - 1, -1);
        System.out.println(list);
        list.add(4, -1);
        System.out.println(list);

    }

}
