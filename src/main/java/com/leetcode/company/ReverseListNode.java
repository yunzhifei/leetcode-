package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-22 8:43 下午
 **/
public class ReverseListNode {

    public static void main(String[] args) {

    }

    ListNode head(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
