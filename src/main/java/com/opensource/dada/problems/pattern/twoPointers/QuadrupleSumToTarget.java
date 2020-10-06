package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 *
 * Example 1:
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *sort[-3,-1,1,1,2,4]
 * Example 2:
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        System.out.println("Result:"+searchQuadruples(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println("Result:"+searchQuadruples(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    static List<List<Integer>> searchQuadruples(int[] arr, int target) {
        List<List<Integer>> quadruples = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0;i<arr.length-3; i++) {
            if (i >0 && arr[i]==arr[i-1]) {
                continue;
            }
            for (int j = i+1; j < arr.length - 2; j++) {
                if (j >i+1 && arr[j]==arr[j-1]) {
                    continue;
                }

                int start = j + 1;
                int end = arr.length - 1;
                while (start < end) {
                    int sum = arr[i] + arr[j] + arr[start] + arr[end];
                    if (sum == target) {
                        quadruples.add(Arrays.asList(arr[i], arr[j], arr[start], arr[end]));
                        start++;
                        end--;
                    } else if (sum < target) {
                        int temp = start;
                        while (arr[temp] == arr[start] && start < end) {
                            start++;
                        }
                    } else {
                        int temp = end;
                        while (arr[temp] == arr[end] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }
        return quadruples;
    }
}
