package com.opensource.dada.problems.pattern.cyclicSort;

import java.util.Arrays;

/** Problem: https://www.geeksforgeeks.org/find-the-missing-number/
 * Codility Problem:
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)],
 * which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)]. *
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("missing number:" + findMissingNumber1(new int[]{2, 3, 1, 5}));
    }
//Solution 2 and 3 are more correct than 1 as per codility tests

    static int findMissingNumber1(int[] A) {
        long sum = Arrays.stream(A).sum();
        long idealSum = ((A.length + 1) * (A.length + 2)) / 2;
        //System.out.println("sum:"+sum+" idealSum:"+idealSum);
        return (int)(idealSum - sum);
    }


    static int findMissingNumber2(int[] A) {
        int smallest = 1;
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    static int findMissingNumber3(int[] A) {
        if (A.length==0) {
            return 1;
        }
        int n = A.length;
        int x1 = A[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ A[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n+1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }
}
