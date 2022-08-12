package com.wen.array;

import java.util.Arrays;

/**
 * <p>
 * 基于数组的 List
 * </p>
 *
 * @author wenjun
 * @since 2022/8/4
 */
public class ArrayList<E> {

    /**
     * 初始化时默认空间大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 初始化时默认空数组
     */
    private static final Object[] DEFAULT_EMPTY_DATA = {};

    /**
     * 底层数组
     */
    private Object[] elements;

    /**
     * 数组元素数量
     */
    private int size;

    public ArrayList() {
        this.elements = DEFAULT_EMPTY_DATA;
    }

    public boolean add(E e) {
        // 最小需要容量
        int minCapacity = size + 1;
        if (elements == DEFAULT_EMPTY_DATA) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        // 扩容
        if (minCapacity > elements.length) {
            int oldCapacity = elements.length;
            // 扩容原来 1/2 大小
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
        elements[size++] = e;
        return true;
    }

    public boolean remove(int index) {
        // 需要移动的元素数量
        int numMoved = size - (index + 1);
        if (numMoved > 0) {
            // 从 elements index + 1 位置开始，迁移 numMoved 个元素到 elements index 位置
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return true;
    }

    public E get(int index) {
        return (E) elements[index];
    }
}
