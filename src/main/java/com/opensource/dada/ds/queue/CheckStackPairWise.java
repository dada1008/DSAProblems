package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a stack of integers,
 * how do you check whether each successive pair of numbers in the stack is consecutive or not.
 * The pairs can be increasing or decreasing, and if the stack has an odd number of elements,
 * the element at the top is left out of a pair. For example,
 * if the stack of elements are [4, 5, -2, -3, 11, 10, 5, 6, 20],
 * then the output should be true because each of the pairs (4, 5), (-2, -3), (11, 10), and (5, 6)
 * consists of consecutive numbers.
 */
public class CheckStackPairWise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(4, 5, -2, -3, 11, 10, 5, 6, 20, 21));
        System.out.println("checkStackPairwiseOrder: "+checkStackPairwiseOrder(stack));
    }

    static boolean checkStackPairwiseOrder(Stack<Integer> stack){
        boolean pairwiseOrdered = true;
        Queue<Integer> queue = new ArrayDeque<>();
        while (!stack.empty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.empty()) {
            int numLeft = stack.pop();
            queue.offer(numLeft);
            if (!stack.empty()) {
                int numRight = stack.pop();
                queue.offer(numRight);
                if (Math.abs(numLeft-numRight)!=1) {
                    pairwiseOrdered = false;
                }
            }
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        return pairwiseOrdered;
    }
}
