package com.opensource.dada.ds.cache;

import java.time.Duration;

public class LRUInMemoryCacheWithDelayQueue<K, V> extends InMemoryCacheWithDelayQueue<K, V> {

    @Override
    public void put(K key, V value, Duration duration) {
        if(super.get(key)!=null) {
            remove(key);
        }
        super.put(key, value, duration);
    }

    @Override
    public V get(K key) {
        CacheEntry<K, V> cacheEntry = super.getEntry(key);
        if(cacheEntry!=null) {
            remove(key);
            super.put(key, cacheEntry.getValue(), cacheEntry.getDuration());
            return cacheEntry.getValue();
        }
        return null;
    }
}
