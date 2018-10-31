package com.opensource.dada.ds.cache;

import java.time.Duration;

public class CacheEntry<K, V> {
    private long expireTime;
    private K key;
    private V value;
    private Duration duration;

    CacheEntry(K key, V value, Duration duration) {
        this.key = key;
        this.value = value;
        this.duration = duration;
        this.expireTime = System.currentTimeMillis() + duration.toMillis();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Duration getDuration() {
        return duration;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expireTime;
    }


}
