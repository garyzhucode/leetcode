package com.garyzhu;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
// 1. 用一个双向链表来存储数据，用map来索引
// 2. 链表越靠前表示越近访问，如果size超过capacity，就淘汰链表尾节点
// 3. get操作时，将其插到链表首位，表示最近发生了访问
public class _146_LruCache {
    class Node {
        int value;
        int k;
        Node next;
        Node prev;

        public Node(int value, int k) {
            this.value = value;
            this.k = k;
            next = null;
            prev = null;
        }
    }

    private Map<Integer, Node> cacheIndex;
    private Node head = null, tail = null;
    private int capacity;

    public _146_LruCache(int capacity) {
        cacheIndex = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cacheIndex.get(key);
        if (node != null) {
            headInsert(node);
        }
        return 0;
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);
        headInsert(node);
        cacheIndex.put(key, node);
        if (cacheIndex.size() > capacity) {

        }
    }

    private void headInsert(Node node) {
        node.next = head.next;
        head.next = node;
    }

    private void tailRemove() {

    }
}
