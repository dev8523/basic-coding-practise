package com.debasish.practise.dsa.topicwise.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    /**
     * This is the laziest implementation using Java's LinkedHashMap.
     * In the real interview, however, it is definitely not what interviewer expected.
     */
    public static class LRUCacheUsingLinkedHashMap {
        private final int CAPACITY;
        private final LinkedHashMap<Integer, Integer> map;

        public LRUCacheUsingLinkedHashMap(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void set(int key, int value) {
            map.put(key, value);
        }
    }

    /**
     * Below is a "normal" HashMap + doubly-linked list implementation:
     * <p>
     * Refer Scaler's "Doubly Linked list" lecture video.
     */
    public class LRUCacheUsingNormalHashMapAndDoublyLL {
        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node head;
        private final Node tail;
        private int count;

        public LRUCacheUsingNormalHashMapAndDoublyLL(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node n = map.get(key);
            if (null == n) {
                return -1;
            }
            update(n);
            return n.value;
        }

        public void set(int key, int value) {
            Node n = map.get(key);
            if (null == n) {
                n = new Node(key, value);
                map.put(key, n);
                add(n);
                ++count;
            } else {
                n.value = value;
                update(n);
            }
            if (count > capacity) {
                Node toDel = tail.prev;
                remove(toDel);
                map.remove(toDel.key);
                --count;
            }
        }

        private void update(Node node) {
            remove(node);
            add(node);
        }

        private void add(Node node) {
            Node after = head.next;
            head.next = node;
            node.prev = head;
            node.next = after;
            after.prev = node;
        }

        private void remove(Node node) {
            Node before = node.prev, after = node.next;
            before.next = after;
            after.prev = before;
        }

        private class Node {
            int key, value;
            Node prev, next;

            Node(int k, int v) {
                this.key = k;
                this.value = v;
            }

            Node() {
                this(0, 0);
            }
        }
    }
}
