package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an integer k and a queue of integers,
 * how do you reverse the order of the first k elements of the queue,
 * leaving the other elements in the same relative order?
 * For example, if k=4 and queue has the elements
 * [10, 20, 30, 40, 50, 60, 70, 80, 90];
 * the output should be
 * [40, 30, 20, 10, 50, 60, 70, 80, 90].
 */
public class ReverseQueueFirstKElements {
    public static void main(String[] args) {
        int k =4;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));
        reverseFirstKElements(k, queue);
        System.out.println("reverseFirstKElements: "+queue);
    }

    static void reverseFirstKElements(int k, Queue<Integer> queue){
        if (queue==null || queue.size() < k ) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<k; i++) {
            stack.push(queue.poll());
        }
        System.out.println("1st for loop= stack:"+stack+" queue:"+queue);
        while (!stack.empty()) {
            queue.offer(stack.pop());
        }

        System.out.println("2nd while loop= stack:"+stack+" queue:"+queue);

        //Wrap around rest of elements
        for (int i=0; i<queue.size()-k; i++) {
            queue.offer(queue.poll());
        }
        System.out.println("3rd for loop= stack:"+stack+" queue:"+queue);
    }
}
