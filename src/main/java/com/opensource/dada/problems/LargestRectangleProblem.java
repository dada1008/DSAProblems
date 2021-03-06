package com.opensource.dada.problems;

import java.util.Stack;

/** Problem:
 * url: https://www.hackerrank.com/challenges/largest-rectangle/problem
 *
 * Skyline Real Estate Developers is planning to demolish a number of old,
 * unoccupied buildings and construct a shopping mall in their place.
 * Your task is to find the largest solid area in which the mall can be constructed.
 *
 * There are a number of buildings in a certain two-dimensional landscape.
 * Each building has a height, given by h[i] where i belongs to [1, n]. If you join k adjacent buildings,
 * they will form a solid rectangle of area
 * k * min(h[i],h[i+1],...,h[i+k-1])
 *
 * For example, the heights array h = [3, 2, 3]. A rectangle of height h=2 and length k=3
 * can be constructed within the boundaries. The area formed is h*k = 2*3 = 6.
 *
 * Function Description
 *
 * Complete the function largestRectangle int the editor below.
 * It should return an integer representing the largest rectangle that can be formed within
 * the bounds of consecutive buildings.
 *
 * largestRectangle has the following parameter(s):
 *
 * h: an array of integers representing building heights
 * Input Format
 *
 * The first line contains , the number of buildings.
 * The second line contains  space-separated integers, each representing the height of a building.
 *
 * Constraints
 *
 * Output Format
 *
 * Print a long integer representing the maximum area of rectangle formed.
 *
 * Sample Input
 *
 * 5
 * 1 2 3 4 5
 * Sample Output
 *
 * 9
 * Explanation
 *
 * An illustration of the test case follows.
 * image
 */
public class LargestRectangleProblem {

    public static void main(String[] args) {
        int[] h = {1,2,3,4,5};
        long height = largestRectangle(h);
        System.out.println("largestRectangle: "+height);
    }
    static long largestRectangle(int[] h) {
        int max = 0, i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i <= h.length) {
            int no = i == h.length ? 0 : h[i];
            if (stack.isEmpty() || no >= h[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int height = h[stack.pop()];
                int w = stack.isEmpty()? i : i - 1 - stack.peek();
                max = Math.max(max, height*w);
            }
        }

        return max;

    }
}
