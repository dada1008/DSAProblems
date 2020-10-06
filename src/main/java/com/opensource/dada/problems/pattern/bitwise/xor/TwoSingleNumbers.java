package com.opensource.dada.problems.pattern.bitwise.xor;

import java.util.Arrays;

/**
 * Problem:
 * In a non-empty array of numbers, every number appears exactly twice except two numbers
 * that appear only once. Find the two numbers that appear only once.
 *
 * Example 1:
 *
 * Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
 * Output: [4, 6]
 * Example 2:
 *
 * Input: [2, 1, 3, 2]
 * Output: [1, 3]
 */
public class TwoSingleNumbers {
    public static void main(String[] args) {
        System.out.println("Result:"+ Arrays.toString(
                findTwoSingleNumbers(new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5})));//4 ,6
        System.out.println("Result:"+ Arrays.toString(
                findTwoSingleNumbers(new int[] {2, 1, 3, 2})));//1, 3
    }

    static int[] findTwoSingleNumbers(int[] arr) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int i = 0; i < arr.length; i++) {
            n1xn2 = n1xn2 ^ arr[i];
        }

        // get the rightmost bit that is '1'
        int rightMostBit = 1;
        while ((rightMostBit & n1xn2)==0) {
            rightMostBit = rightMostBit << 1;
        }
        int num1 =0, num2 =0;
        for (int num: arr) {
            if ((num & rightMostBit) !=0) {// the bit is set
                num1 ^= num;
            } else {// the bit is not set
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
