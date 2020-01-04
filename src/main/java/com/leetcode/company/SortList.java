package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-27 10:14 下午
 **/
public class SortList {
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

        mergeSortList(listNode);
    }

    static ListNode mergeSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        int mergeSize = 1;

        while (true) {

            int mergeCount = 0;

            ListNode pre = dummy;
            ListNode firstStart = head;

            while (pre.next != null) {
                firstStart = pre.next;
                ListNode firstEnd = moveStep(mergeSize, pre);
                ListNode secondStart = firstEnd.next;
                firstEnd.next = null;
                ListNode secondEnd = null;
                ListNode next = null;
                if (secondStart != null) {
                    secondEnd = moveStep(mergeSize - 1, secondStart);
                    next = secondEnd.next;
                    secondEnd.next = null;
                }

                ListNode merge = merge(firstStart, secondStart);
                mergeCount++;
                pre.next = merge;
                ListNode listNode = moveStep(mergeSize * 2, merge);
                listNode.next = next;
                pre = moveStep(mergeSize * 2, pre);

            }
            mergeSize *= 2;
            if (mergeCount == 1) {
                break;
            }
        }


        return dummy.next;
    }


    public static ListNode moveStep(int step, ListNode head) {
        for (int i = 0; i < step; i++) {
            if (head.next == null) {
                return head;
            }
            head = head.next;

        }
        return head;
    }

    public static ListNode merge(ListNode first, ListNode second) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
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
