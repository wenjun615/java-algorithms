package com.wen.array;

/**
 * <p>
 * List 接口
 * </p>
 *
 * @author wenjun
 * @since 2022/8/4
 */
public interface List<E> {

    boolean add(E e);

    E remove(int index);

    E get(int index);
}
