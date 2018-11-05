package com.opensource.dada.ds.cache;

import java.time.Duration;

public class TestCache {
    public static void main(String[] args) {
        //testInMemoryCacheWithDelayQueue();
        testLRUInMemoryCacheWithDelayQueue();
    }

    public static void testLRUInMemoryCacheWithDelayQueue() {
        LRUInMemoryCacheWithDelayQueue<String, String> cache = new LRUInMemoryCacheWithDelayQueue<>();
        cache.put("1","1");
        cache.put("2","2", Duration.ofSeconds(15));
        cache.put("3","3", Duration.ofSeconds(5));
        sleepFor(3000);
        cache.put("1","1", Duration.ofSeconds(5));
        cache.get("3");
        sleepFor(15000);
        cache.stop();
        System.out.println("Thread: "+Thread.currentThread().getName()+" : Cache testing done.");
    }

    public static void testInMemoryCacheWithDelayQueue() {
        InMemoryCacheWithDelayQueue<String, String> cache = new InMemoryCacheWithDelayQueue<>();
        cache.put("1","1");
        cache.put("2","2", Duration.ofSeconds(15));
        sleepFor(3000);
        cache.put("3","3", Duration.ofSeconds(5));
        sleepFor(15000);
        cache.stop();
        System.out.println("Thread: "+Thread.currentThread().getName()+" : Cache testing done.");
    }

    public static void sleepFor(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
