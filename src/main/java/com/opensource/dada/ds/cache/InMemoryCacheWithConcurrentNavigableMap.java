package com.opensource.dada.ds.cache;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryCacheWithConcurrentNavigableMap<K, V> implements Cache<K, V> {
    private ConcurrentMap<K, CacheEntry<K, V>> map = new ConcurrentHashMap<>();
    private ConcurrentNavigableMap<Long, CacheEntry<K, V>> queue = new ConcurrentSkipListMap<>();
    private Duration DEFAULT_CACHE_DURATION = Duration.ofSeconds(10);
    private Thread evictionThread = new Thread(new EvictionTask());

    private volatile boolean stop;
    private volatile long nextExpireTime = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition lockCondition = lock.newCondition();
    private volatile boolean notified;

    public InMemoryCacheWithConcurrentNavigableMap() {
        super();
        evictionThread.start();
    }

    public void shutdown() {
        stop = true;
        evictionThread.interrupt();
        try {
            evictionThread.join();
        } catch (InterruptedException e) {
            // TODO: add this
        }
    }

    @Override
    public void put(K key, V value) {
        put(key, value, DEFAULT_CACHE_DURATION);
    }

    @Override
    public void put(K key, V value, Duration duration) {
        CacheEntry<K, V> entry = new CacheEntry(key, value, duration);
        map.put(key, entry);
        addInQueue(entry);
    }

    private void addInQueue(CacheEntry<K, V> entry) {
        queue.put(entry.getExpireTime(), entry);
    }

    private void removeFromQueue(CacheEntry<K, V> entry) {
        queue.remove(entry.getExpireTime(), entry);
    }

    @Override
    public V get(K key) {
        CacheEntry<K, V> entry = map.get(key);
        return entry == null ? null : entry.getValue();
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
        //queue.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void stop() {
        shutdown();
    }

    /**
     * <p>
     * This implementation checks if the current next eviction time is different
     * from the last next eviction time, and if so notifies the eviction thread,
     * causing it to wake-up and recalculate its waiting time.
     * </p>
     */
    protected void onScheduleEviction(CacheEntry<K, V> e) {
        if (getNextEvictionTime() != nextExpireTime) {
            notifyEviction();
        }
    }

    private void notifyEviction() {
        lock.lock();
        try {
            notified = true;
            lockCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * <p>
     * This implementation checks if the current next eviction time is different
     * from the last next eviction time, and if so notifies the eviction thread,
     * causing it to wake-up and recalculate its waiting time.
     * </p>
     */
    protected void onCancelEviction(CacheEntry<K, V> e) {
        if (getNextEvictionTime() != nextExpireTime) {
            notifyEviction();
        }
    }

    public long getNextEvictionTime() {
        try {
            return (!queue.isEmpty()) ? queue.firstKey() : 0;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public boolean expireEntries() {
        boolean result = false;
        ConcurrentNavigableMap<Long, CacheEntry<K, V>> head = queue.headMap(System.currentTimeMillis());
        if (!head.isEmpty()) {
            for (CacheEntry<K, V> e : head.values()) {
                map.remove(e.getKey());
            }
            head.clear();
            result = true;
        }
        return result;
    }

    class EvictionTask implements Runnable {

        @Override
        public void run() {
            while (!stop) {
                nextExpireTime = getNextEvictionTime();
                long timeout = getWaitTime(nextExpireTime);
                while (timeout >= 0) {
                    // The timeout is 0 (forever) or positive - wait
                    if (!waitFor(timeout) && !stop) {
                        // The timeout did not expire and we are not finished -
                        // calculate the next timeout
                        nextExpireTime = getNextEvictionTime();
                        timeout = getWaitTime(nextExpireTime);
                    } else {
                        // The timeout expired or we are finished - get out
                        break;
                    }
                }

                expireEntries();
            }
        }

        /**
         * Calculates the wait timeout (in millseconds) to the specified moment
         * in time (in millseconds). If the time is 0 (forever), return also 0
         * (forever). A negative value returned from this method means that no
         * waiting should happen.
         */
        private long getWaitTime(long time) {
            if (time > 0) {
                long x = time - System.currentTimeMillis();
                return (x != 0) ? x : -1;
            }
            return 0;
        }

        /**
         * Waits for the specified timeout (in millseconds). Returns true if the
         * timeout expired and false if thread was notified or interrupted.
         */
        private boolean waitFor(long timeout) {
            boolean result = true;
            lock.lock();
            try {
                notified = false;
                lockCondition.await(timeout, TimeUnit.MILLISECONDS);
                result = !notified;
            } catch (InterruptedException e) {
                result = false;
            } finally {
                lock.unlock();
            }

            return result;
        }
    }

}
