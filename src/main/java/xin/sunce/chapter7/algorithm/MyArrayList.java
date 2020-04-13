package xin.sunce.chapter7.algorithm;

import java.util.Arrays;

/**
 * 自定义ArrayList
 * 插入元素，删除元素，获取元素
 */
public class MyArrayList {

    private Object[] data;
    private int size;

    private static int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("setting wrong capacity");
        }
        this.data = new Object[capacity];
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     * @see java.util.ArrayList
     */
    public Object get(int index) {
        rangeCheck(index);
        return data[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 移除元素
     * 长度为5，移除index为2
     * src:  1 2 3 4 5 ;
     * dest: 1 2 4 5 null
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        rangeCheck(index);
        Object result = data[index];
        int copyLength = size - index - 1;
        System.arraycopy(data, index + 1, data, index, copyLength);
        size--;
        return result;
    }

    /**
     * 新增元素
     * 长度为5，给index为2新增元素0
     * src:  1 2 3 4 5 ;
     * dest: 1 2 0 3 4 5 ;
     *
     * @param index
     * @param element
     */
    public void add(int index, Object element) {
        rangeCheck(index);
        //TODO 确认容量以及扩容
        int copyLength = size - index;
        System.arraycopy(data, index, data, index + 1, copyLength);
        data[index] = element;
        size++;
    }

    @Override
    public String toString() {
        return "[data=" + Arrays.toString(data) +
                ", size=" + size + "]";
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        System.out.println(list);
    }
}
