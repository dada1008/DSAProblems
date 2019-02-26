package com.opensource.dada.ds.cache;

import java.time.Duration;

public interface Cache<K,V> {
    void put(K key, V value);
    void put(K key, V value, Duration duration);
    V get(K key);
    void remove(K key);
    void clear();
    int size();
    void stop();
}
