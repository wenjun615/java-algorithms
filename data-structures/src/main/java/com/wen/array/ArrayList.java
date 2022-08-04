package com.wen.array;

import java.util.Arrays;

/**
 * <p>
 * null.
 * </p>
 *
 * @author wenjun
 * @since 2022/8/4
 */
public class ArrayList<E> implements List<E> {

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 元素数组
     */
    transient Object[] elementData;

    /**
     * 当前元素数量
     */
    private int size;

    public ArrayList() {
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    @Override
    public boolean add(E e) {
        // 最小需要容量
        int minCapacity = size + 1;
        if (elementData == EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 扩容
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - (index + 1);
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }
}
