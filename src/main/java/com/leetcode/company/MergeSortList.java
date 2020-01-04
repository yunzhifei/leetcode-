package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2020-01-01 10:14 下午
 **/
public class MergeSortList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);


        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        insertionSortList(listNode);
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-2);
        while (head != null) {
            ListNode next = head.next;
            insert(dummy, head);
            head = next;
        }
        return dummy.next;
    }

    static void insert(ListNode dummy, ListNode insert) {
        while (dummy.next != null && dummy.next.val < insert.val) {
            dummy = dummy.next;
        }

        insert.next = dummy.next;
        dummy.next = insert;
    }
}

