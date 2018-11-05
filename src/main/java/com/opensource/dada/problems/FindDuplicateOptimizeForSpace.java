package com.opensource.dada.problems;

import java.util.stream.IntStream;

/**
 * Problem:
 * Find a duplicate, Space Edition™.
 * <p>
 * We have an array of integers, where:
 * <p>
 * The integers are in the range 1..n1..n
 * The array has a length of n+1
 * It follows that our array has at least one integer which appears at least twice.
 * But it may have several duplicates, and each duplicate may appear more than twice.
 * <p>
 * Write a method which finds an integer that appears more than once in our array.
 * (If there are multiple duplicates, you only need to find one of them.)
 * <p>
 * We're going to run this method on our new, super-hip MacBook Pro With Retina Display™.
 * Thing is, the damn thing came with the RAM soldered right to the motherboard,
 * so we can't upgrade our RAM. So we need to optimize for space!
 */
public class FindDuplicateOptimizeForSpace {

    public static int findRepeat(int[] theArray) {

        int result = 0;

        //result = summationWay(theArray);
        result = xorWay(theArray);

        return result;
    }

    private static int summationWay(int[] theArray) {
        int actual_sum = IntStream.of(theArray).sum();
        int sumOfAll = (theArray.length * (theArray.length + 1) / 2);
        int expected_sum = theArray.length * (theArray.length - 1) / 2;
        int missing = sumOfAll - expected_sum;
        int duplicate = actual_sum - expected_sum;
        if (actual_sum == sumOfAll) {
            missing = duplicate = 0;
        }
        System.out.println("[sumOfAll: " + sumOfAll + "] [missing: " + missing + "] [duplicate: " + duplicate + "] [actual_sum: " + actual_sum + "] [expected_sum: " + expected_sum + "]");
        return duplicate;
    }
    private static int xorWay(int[] A) {
        {
            int xor = 0;

            // take xor of all array elements
            for (int i = 0; i < A.length; i++) {
                xor ^= A[i];
            }

            // take xor of numbers from 1 to n-1
            for (int i = 1; i <= A.length - 1; i++) {
                xor ^= i;
            }

            // same elements will cancel out each other as a ^ a = 0,
            // 0 ^ 0 = 0 and a ^ 0 = a

            // xor will contain the missing number
            return xor;
        }
    }
}
