package xin.sunce.chapter7.algorithm;

import java.util.Arrays;

/**
 * 自定义ArrayList
 * 插入元素，删除元素，获取元素
 *
 * @author Lowrie
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
     * 顺序写
     *
     * @param element
     * @return
     */
    public boolean add(Object element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    /**
     * 随机写
     * 长度为5，给index为2新增元素0
     * src:  1 2 3 4 5 ;
     * dest: 1 2 0 3 4 5 ;
     *
     * @param index
     * @param element
     */
    public boolean add(int index, Object element) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        int copyLength = size - index;
        System.arraycopy(data, index, data, index + 1, copyLength);
        data[index] = element;
        size++;
        return true;
    }

    private void ensureCapacity(int capacity) {
        if (capacity - data.length > 0) {
            grow(capacity);
        }
    }

    private void grow(int capacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (newCapacity < capacity) {
            newCapacity = capacity;
        }
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public String toString() {
        return "[data=" + Arrays.toString(data) +
                ", size=" + size + "]";
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
    }
}
