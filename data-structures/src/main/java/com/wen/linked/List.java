package com.wen.linked;

/**
 * <p>
 * List 接口
 * </p>
 *
 * @author wenjun
 * @since 2022-07-25
 */
public interface List<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();
}
