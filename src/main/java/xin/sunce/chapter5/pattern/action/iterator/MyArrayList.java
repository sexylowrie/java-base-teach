package xin.sunce.chapter5.pattern.action.iterator;

import java.util.*;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 自定义ArrayList,简版不考虑扩容
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class MyArrayList<E> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private int modCount;//修改计数器

    public MyArrayList() {
        data = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public void add(E element) {
        if (size > data.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[size] = element;
        size++;
        modCount++;
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) data[index];
    }

    public void remove(int index) {
        rangeCheck(index);
        int moveNum = size - index - 1;
        if (moveNum > 0) {
            System.arraycopy(data, index, data, index + 1, moveNum);
        }
        modCount++;
        data[--size] = null;

    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return this.size;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MyArrayList.class.getSimpleName() + "[", "]")
                .add("data=" + Arrays.toString(data))
                .toString();
    }

    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator {

        private int cursor;
        private int lastRet;
        private int expectedModCount;

        public MyArrayListIterator() {
            cursor = 0;
            lastRet = -1;
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            checkConcurModify();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] data = MyArrayList.this.data;
            Object e = data[lastRet = i];
            cursor = i + 1;
            return e;
        }

        @Override
        public void remove() {
            checkConcurModify();
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;

        }

        private void checkConcurModify() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

}
