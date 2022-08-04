package com.wen.test;

import com.wen.linked.LinkedList;
import com.wen.linked.List;

/**
 * <p>
 * null.
 * </p>
 *
 * @author wenjun
 * @since 2022-07-25
 */
public class ApiTest {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        list.printLinkList();
        list.addFirst("d");
        list.remove("b");
        list.printLinkList();
    }
}
