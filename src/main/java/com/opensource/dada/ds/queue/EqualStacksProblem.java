package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem:
 * url: https://www.hackerrank.com/challenges/equal-stacks/problem
 * <p>
 * You have three stacks of cylinders where each cylinder has the same diameter,
 * but they may vary in height. You can change the height of a stack by removing
 * and discarding its topmost cylinder any number of times.
 * <p>
 * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
 * This means you must remove zero or more cylinders from the top of zero or more of the three stacks
 * until they're all the same height, then print the height.
 * The removals must be performed in such a way as to maximize the height.
 * <p>
 * Note: An empty stack is still a stack.
 * <p>
 * Input Format
 * <p>
 * The first line contains three space-separated integers, , , and ,
 * describing the respective number of cylinders in stacks , , and .
 * The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:
 * <p>
 * The second line contains  space-separated integers describing the cylinder heights in stack.
 * The first element is the top of the stack.
 * The third line contains  space-separated integers describing the cylinder heights in stack.
 * The first element is the top of the stack.
 * The fourth line contains  space-separated integers describing the cylinder heights in stack.
 * The first element is the top of the stack.
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the maximum height at which all stacks will be of equal height.
 * <p>
 * Sample Input
 * <p>
 * 5 3 4
 * 3 2 1 1 1
 * 4 3 2
 * 1 1 4 1
 * Sample Output
 * <p>
 * 5
 * Explanation
 * <p>
 * Initially, the stacks look like this:
 * <p>
 * initial stacks
 * <p>
 * Observe that the three stacks are not all the same height.
 * To make all stacks of equal height, we remove the first cylinder from stacks  and ,
 * and then remove the top two cylinders from stack  (shown below).
 * <p>
 * modified stacks
 * <p>
 * As a result, the stacks undergo the following change in height:
 * 8 - 3 = 5
 * 9 - 4 = 5
 * 7 - 1 - 1 = 5
 * All three stacks now have height = 5. Thus, we print 5 as our answer.
 */
public class EqualStacksProblem {

    public static void main(String[] args) {
        int[] h1 = {3, 2, 1, 1, 1};
        int[] h2 = {4, 3, 2};
        int[] h3 = {1, 1, 4, 1};

        int height = equalStacks(h1, h2, h3);
        System.out.println("Height: " + height);
    }

    public static int equalStacks(int[] h1, int[] h2, int[] h3) {

        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Queue<Integer> queue3 = new ArrayDeque<>();

        int height1 = 0;
        int height2 = 0;
        int height3 = 0;

        for (int i = 0; i < h1.length; i++) {
            queue1.add(h1[i]);
            height1 += h1[i];
        }

        for (int i = 0; i < h2.length; i++) {
            queue2.add(h2[i]);
            height2 += h2[i];
        }

        for (int i = 0; i < h3.length; i++) {
            queue3.add(h3[i]);
            height3 += h3[i];
        }

        int minHeight = Math.min(height1, Math.min(height2, height3));

        while (height1 != height2 || height2 != height3) {
            while (height1 > minHeight) {
                height1 -= queue1.remove();
            }
            minHeight = Math.min(height1, Math.min(height2, height3));

            while (height2 > minHeight) {
                height2 -= queue2.remove();
            }
            minHeight = Math.min(height1, Math.min(height2, height3));

            while (height3 > minHeight) {
                height3 -= queue3.remove();
            }
            minHeight = Math.min(height1, Math.min(height2, height3));
        }

        return minHeight;
    }
}
