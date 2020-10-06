package com.opensource.dada.problems.pattern.twoPointers;

import java.util.Arrays;

/**
 * Problem:
 * Given a sorted array, create a new array containing squares of all the number
 * of the input array in the sorted order.
 *
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0 1 1 4 9]
 */
public class SquaringSortedArray {
    public static void main(String[] args) {
        System.out.println("Result:"+ Arrays.toString(makeSquares(new int[] {-2, -1, 0, 2, 3})));
        System.out.println("Result:"+ Arrays.toString(makeSquares(new int[] {-3, -1, 0, 1, 2})));
    }

    static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0, right = arr.length -1, squareIndex = arr.length -1;
        while (left < right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[squareIndex] = leftSquare;
                left++;
            } else {
                squares[squareIndex] = rightSquare;
                right--;
            }
            squareIndex--;
        }
        return squares;
    }
}
