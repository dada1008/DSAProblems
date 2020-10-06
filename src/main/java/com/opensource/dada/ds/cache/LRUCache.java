package com.opensource.dada.ds.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item
 * before inserting a new item.
 */

public class LRUCache<K, V> {
    int capacity;
    Map<K, Node> map = new HashMap<>();
    Node<K, V> head = null;
    Node<K, V> end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return null;
    }

    public void remove(Node<K, V> n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    public void setHead(Node<K, V> n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    public void set(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node<K, V> created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);

            } else {
                setHead(created);
            }

            map.put(key, created);
        }
    }

    class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
