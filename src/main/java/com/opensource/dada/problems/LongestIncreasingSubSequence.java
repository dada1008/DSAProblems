package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent/problem
 *
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        System.out.println("Result:"+findLIS(array));
        System.out.println("Result:"+longestIncreasingSubSequence(array));
    }

    //Complexity time: O(nlogn), space: O(n)
    public static int findLIS(int[] s) {
        int[] temp = new int[s.length];
        int sequenceLength = 0;
        for(int num: s){
            int index = Arrays.binarySearch(temp, 0, sequenceLength, num);
            if(index < 0){
                index = - (index + 1);
            }
            temp[index] = num;
            if(index==sequenceLength){
                sequenceLength++;
            }
        }
        return sequenceLength;
    }

    //Complexity time: O(nlogn), space: O(n)
    public static List<Integer> longestIncreasingSubSequence2(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, -1);
        int[] indices = new int[array.length+1];
        Arrays.fill(indices, -1);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int newLength = binarySearch(1, length, indices, array, num);
            sequences[i] = indices[newLength - 1];
            indices[newLength] = i;
            length = Math.max(length, newLength);
        }
        return buildSequence(array, sequences, indices[length]);
    }

    private static int binarySearch(int startIndex, int endIndex, int[] indices, int[] array, int num) {
        if (startIndex > endIndex) {
            return startIndex;
        }
        int midIndex = (startIndex + endIndex)/2;
        if (array[indices[midIndex]] < num) {
            startIndex = midIndex + 1;
        } else {
            endIndex = midIndex - 1;
        }
        return binarySearch(startIndex, endIndex, indices, array, num);
    }

    //Complexity time: O(n^2), space: O(n)
    static List<Integer> longestIncreasingSubSequence(int[] array){
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, -1);
        int[] lengths = new int[array.length];
        Arrays.fill(lengths, 1);
        int maxLengthIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && lengths[j] + 1 >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    sequences[i] = j;
                }
            }
            if (lengths[i] >= lengths[maxLengthIndex]) {
                maxLengthIndex = i;
            }
        }
        return buildSequence(array, sequences, maxLengthIndex);
    }

    private static List<Integer> buildSequence(int[] array, int[] sequences, int currentIndex) {
        List<Integer> result = new ArrayList<>();
        while (currentIndex!= -1) {
            result.add(array[currentIndex]);
            currentIndex = sequences[currentIndex];
        }
        Collections.reverse(result);
        return result;
    }

}
