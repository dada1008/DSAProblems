package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a queue of integers,
 * rearrange the elements by interleaving the first half of the list with the second half of the list.
 * For example, suppose a queue stores the following sequence of values: [11, 12, 13, 14, 15, 16, 17, 18, 19, 20].
 * Consider the two halves of this list: first half: [11, 12, 13, 14, 15]
 * second half: [16, 17, 18, 19, 20].
 * These are combined in an alternating fashion to form a sequence of interleave pairs:
 * the first values from each half (11 and 16),
 * then the second values from each half (12 and 17),
 * then the third values from each half (13 and 18), and so on.
 * In each pair, the value from the first half appears before the value from the second half.
 * Thus, after the call, the queue stores the following values:
 * [11, 16, 12, 17, 13, 18, 14, 19, 15, 20].
 */
public class InterleavingQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        interleavingQueue(queue);
        System.out.println("checkStackPairwiseOrder: "+queue);
    }

    static void interleavingQueue(Queue<Integer> queue){
        if (queue.size()%2!=0) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size()/2;
        for (int i=0; i<halfSize; i++) {
            stack.push(queue.poll());
        }
        System.out.println("1st for loop= stack:"+stack+" queue:"+queue);
        while (!stack.empty()) {
            queue.offer(stack.pop());
        }

        System.out.println("2nd while loop= stack:"+stack+" queue:"+queue);

        for (int i=0; i<halfSize; i++) {
            queue.offer(queue.poll());
        }
        System.out.println("3rd for loop= stack:"+stack+" queue:"+queue);
        for (int i=0; i<halfSize; i++) {
            stack.push(queue.poll());
        }
        System.out.println("4rd for loop= stack:"+stack+" queue:"+queue);
        while (!stack.empty()) {
            queue.offer(stack.pop());
            queue.offer(queue.poll());
        }
        System.out.println("5th for loop= stack:"+stack+" queue:"+queue);
    }
}
