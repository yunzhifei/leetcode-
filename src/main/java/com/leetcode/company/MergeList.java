package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-22 8:31 下午
 **/
public class MergeList {


    public Node merge(Node first, Node second) {

        Node dummy = new Node();
        Node cur = dummy;
        while (first != null && second != null) {
            if (first.val > second.val) {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            } else {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
        }

        if (first != null) {
            cur.next = first;
        }
        if (second != null) {
            cur.next = second;
        }

        return dummy.next;
    }
}


class Node {
    int val;
    Node next;
}
