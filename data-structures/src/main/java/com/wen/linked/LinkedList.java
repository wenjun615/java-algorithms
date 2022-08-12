package com.wen.linked;

/**
 * <p>
 * 单向链表
 * </p>
 *
 * @author wenjun
 * @since 2022-07-25
 */
public class LinkedList<E> {

    private int size;

    private Node<E> first;

    private Node<E> last;

    public LinkedList() {
    }

    public boolean addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        return true;
    }

    public boolean addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        Node<E> temp = first;
        if (o == null) {
            while (temp != null) {
                if (temp.element == null) {
                    return removeNode(temp);
                }
                temp = temp.next;
            }
        } else {
            while (temp != null) {
                if (o.equals(temp.element)) {
                    return removeNode(temp);
                }
                temp = temp.next;
            }
        }
        return false;
    }

    private boolean removeNode(Node<E> node) {
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.element = null;
        size--;
        return true;
    }

    public E get(int index) {
        return node(index).element;
    }

    private Node<E> node(int index) {
        Node<E> temp;
        // 判断 index 在前半段还是后半段（index 从 0 开始），>> 1 表示除 2
        if (index < (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    private static class Node<E> {

        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
