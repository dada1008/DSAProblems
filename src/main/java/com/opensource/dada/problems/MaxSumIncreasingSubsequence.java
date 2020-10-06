package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        maxSumIncreasingSubsequence(new int[]{8, 12, 2, 3, 15, 5, 7});
    }

    static void maxSumIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        for (int i = 0; i < sequences.length; i++) {
            sequences[i] = -1;
        }
        int[] sums = Arrays.copyOf(array, array.length);
        int maxSumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && sums[j]+currentNum >= sums[i]) {
                    sums[i] = sums[j]+currentNum;
                    sequences[i] = j;
                }
            }
            if (sums[i] >= sums[maxSumIndex]) {
                maxSumIndex = i;
            }
        }
        int maxSum = sums[maxSumIndex];
        List<Integer> list = buildSequence(array, sequences, maxSumIndex);
        System.out.println("Max Sum:"+ maxSum);
        System.out.println("Sequence list:"+ list);
    }

    private static List<Integer> buildSequence(int[] array, int[] sequences, int maxSumIndex) {
        List<Integer> result = new ArrayList<>();
        while (maxSumIndex != -1) {
            result.add(array[maxSumIndex]);
            maxSumIndex = sequences[maxSumIndex];
        }
        Collections.reverse(result);
        return result;
    }

}
