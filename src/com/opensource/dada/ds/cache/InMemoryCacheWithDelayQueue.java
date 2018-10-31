package com.opensource.dada.ds.cache;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.*;

public class InMemoryCacheWithDelayQueue<K, V> implements Cache<K, V> {
    private ConcurrentMap<K, SoftReference<CacheEntry<K, V>>> map = new ConcurrentHashMap<>();
    private final DelayQueue<DelayedCacheEntry<K, CacheEntry<K, V>>> cleanupQueue = new DelayQueue<>();

    private Duration DEFAULT_CACHE_DURATION = Duration.ofSeconds(10);
    private Thread evictionThread = new Thread(new EvictionTask(), "EvictionThread");

    public InMemoryCacheWithDelayQueue() {
        super();
        evictionThread.start();
    }

    @Override
    public void put(K key, V value) {
        put(key, value, DEFAULT_CACHE_DURATION);
    }

    @Override
    public void put(K key, V value, Duration duration) {
        CacheEntry<K, V> entry = new CacheEntry(key, value, duration);
        SoftReference<CacheEntry<K, V>> reference = new SoftReference<>(entry);
        map.put(key, reference);
        cleanupQueue.put(new DelayedCacheEntry<>(key, reference, entry.getExpireTime()));
    }

    @Override
    public V get(K key) {
        CacheEntry<K, V> cacheEntry = Optional.ofNullable(map.get(key)).map(SoftReference::get).orElse(null);
        if(cacheEntry!=null) {
            return cacheEntry.getValue();
        }

        return null;
    }

    public CacheEntry<K,V> getEntry(K key) {
        SoftReference<CacheEntry<K,V>> reference = map.get(key);
       return (reference==null? null: reference.get());
    }

    @Override
    public void remove(K key) {
        map.remove(key);
        System.out.println("Thread: "+Thread.currentThread().getName()+" :Removed Key:"+key);
    }

    @Override
    public void clear() {
        map.clear();
        //cleanupQueue.clear();
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    public void stop() {
        this.evictionThread.interrupt();
    }

    private static class DelayedCacheEntry<K, E> implements Delayed {

        private final K key;
        private final SoftReference<E> reference;
        private final long expiryTime;

        public DelayedCacheEntry(K key, SoftReference<E> reference, long expiryTime) {
            this.key = key;
            this.reference = reference;
            this.expiryTime = expiryTime;
        }

        public K getKey() {
            return key;
        }

        public SoftReference<E> getReference() {
            return reference;
        }

        public long getExpiryTime() {
            return expiryTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(expiryTime, ((DelayedCacheEntry) o).expiryTime);
        }
    }

    class EvictionTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    DelayedCacheEntry<K, CacheEntry<K, V>> delayedCacheEntry = cleanupQueue.take();
                    remove(delayedCacheEntry.getKey());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
