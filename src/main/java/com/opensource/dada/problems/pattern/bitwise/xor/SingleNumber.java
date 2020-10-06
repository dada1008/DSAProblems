package com.opensource.dada.problems.pattern.bitwise.xor;

/**
 * Problem:
 * In a non-empty array of integers, every number appears twice except for one, find that single number.
 *
 * Example 1:
 *
 * Input: 1, 4, 2, 1, 3, 2, 3
 * Output: 4
 * Example 2:
 *
 * Input: 7, 9, 7
 * Output: 9
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println("Result:"+findSingleNumber(new int[] {1, 4, 2, 1, 3, 2, 3}));//4
        System.out.println("Result:"+findSingleNumber(new int[] {7, 9, 7}));//9
    }

    static int findSingleNumber(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        return sum;
    }
}
