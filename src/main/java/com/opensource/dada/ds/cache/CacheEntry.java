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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CacheEntry<?, ?> that = (CacheEntry<?, ?>) o;

        if (expireTime != that.expireTime) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return duration != null ? duration.equals(that.duration) : that.duration == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (expireTime ^ (expireTime >>> 32));
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
