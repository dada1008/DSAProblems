package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueTwoStacks {

    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }
        return outStack.pop();
    }

    public static void basicQueueOperationsTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("dequeue #1: "+(1==q.dequeue()));
        System.out.println("dequeue #2: "+(2==q.dequeue()));
        q.enqueue(4);
        System.out.println("dequeue #3: "+(3==q.dequeue()));
        System.out.println("dequeue #4: "+(4==q.dequeue()));
    }

    public static void exceptionWhenDequeueFromNewQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.dequeue();
    }

    public static void exceptionWhenDequeueFromEmptyQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

    public static void main(String[] args) {
        basicQueueOperationsTest();
        try {
        exceptionWhenDequeueFromEmptyQueueTest();
        } catch (Exception e) {
            System.err.println("exceptionWhenDequeueFromEmptyQueueTest Exception:"+e);
        }
        try {
            exceptionWhenDequeueFromNewQueueTest();
        } catch (Exception e) {
            System.err.println("exceptionWhenDequeueFromNewQueueTest Exception:"+e);
        }
    }
}
