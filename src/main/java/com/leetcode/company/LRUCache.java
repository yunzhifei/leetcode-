package com.leetcode.company;

import java.util.HashMap;

/**
 * @author yun zhi fei
 * @create 2019-12-29 9:15 下午
 **/
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1);
        lruCache.put(2);
        lruCache.put(3);
        lruCache.put(4);
        lruCache.get(2);
        System.out.println("lruCache = " + lruCache);
    }

    private int cacheSize = 0;

    private HashMap<Integer, DLinkedNode> dLinkedNodeHashMap = new HashMap<>();

    private DLinkedNode head = null;
    private DLinkedNode tail = null;
    private int count = 0;

    public int get(int key) {
        if (!dLinkedNodeHashMap.containsKey(key)) {
            return -1;
        }
        DLinkedNode dLinkedNode = dLinkedNodeHashMap.get(key);
        if (dLinkedNode != head) {
            moveToHead(dLinkedNode);
        }
        return dLinkedNode.val;
    }

    public boolean put(int key) {
        if (dLinkedNodeHashMap.containsKey(key)) {
            DLinkedNode dLinkedNode = dLinkedNodeHashMap.get(key);
            moveToHead(dLinkedNode);
            return true;
        }
        if (count >= cacheSize) {
            dLinkedNodeHashMap.remove(tail.val);
            popTail();
            count--;
        }
        DLinkedNode dLinkedNode = new DLinkedNode(key);
        addHead(dLinkedNode);
        count++;
        dLinkedNodeHashMap.put(key, dLinkedNode);

        return true;
    }

    LRUCache(int size) {
        cacheSize = size;
    }

    public void addHead(DLinkedNode dLinkedNode) {
        dLinkedNode.next = head;
        if (head == null) {
            tail = dLinkedNode;
        }
        head = dLinkedNode;
        head.pre = null;
        if (dLinkedNode.next != null) {
            dLinkedNode.next.pre = dLinkedNode;
        }

    }

    public void moveToHead(DLinkedNode dLinkedNode) {
        if (dLinkedNode != head) {
            dLinkedNode.pre.next = dLinkedNode.next;
            if (dLinkedNode.next != null) {
                dLinkedNode.next.pre = dLinkedNode.pre;
            }
            dLinkedNode.next = head;
            head = dLinkedNode;
            dLinkedNode.next.pre = dLinkedNode;
            head.pre = null;
        }
    }

    public void popTail() {
        tail.pre.next = null;
        DLinkedNode pre = tail.pre;
        tail.pre = null;
        tail = pre;
    }

}

class DLinkedNode {
    int val;
    DLinkedNode next;
    DLinkedNode pre;

    public DLinkedNode(int val) {
        this.val = val;
    }
}


