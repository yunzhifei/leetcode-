package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-28 9:14 上午
 **/
public class KReverseListNode {

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

        reverseKGroup(listNode, 3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        int count = 0;
        ListNode pre = dummy;
        ListNode start = dummy.next;
        ListNode end = start;


        while (pre.next != null && end.next != null) {
            ListNode next = null;
            for (count = 0; count < k - 1; count++) {
                if (end.next != null) {
                    end = end.next;
                } else {
                    break;
                }
            }

            if (count < k - 1) {
                break;
            }
            //断开链表
            next = end.next;
            end.next = null;

            //翻转以后接回去
            reverse(start);
            pre.next = end;
            start.next = next;

            //走到下一个起始位置
            pre = start;
            start = pre.next;
            end = start;
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


    static ListNode reverse(ListNode head) {
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
