package com.opensource.dada.ds.hash;

public class CustomConcurrentHashMap<K, V> {
    public static void main(String[] args) {
        System.out.println("Hello Custom Hash Map");
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
    }
}
