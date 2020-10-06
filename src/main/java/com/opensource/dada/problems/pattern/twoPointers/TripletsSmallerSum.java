package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k
 * are three different indices. Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * <p>
 * Input: [-1, 4, 2, 1, 3], target=5 [-1, 1, 2, 3, 4]
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletsSmallerSum {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        List<int[]> result = threeSmallerSum2(new int[]{-1, 0, 2, 3}, 3);
        System.out.println("Result:");//2
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void test2() {
        List<int[]> result = threeSmallerSum(new int[]{-1, 4, 2, 1, 3}, 5);
        System.out.println("Result:");//4
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static List<int[]> threeSmallerSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum < target) {
                    for (int j = start + 1; j <= end; j++) {
                        resultList.add(new int[]{arr[i], arr[start], arr[j]});
                    }
                    start++;
                } else {
                    end--;
                }
            }
        }
        return resultList;
    }
    // As of now this gives correct count
    static List<int[]> threeSmallerSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], resultList, i);
        }
        System.out.println("Total count:" + count);
        return resultList;
    }

    private static int searchPair(int[] arr, int target, List<int[]> resultList, int i) {
        int count = 0;
        int start = i + 1;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < target) {
                /**
                 * found the triplet since arr[right] >= arr[left], therefore,
                 * we can replace arr[right] by any number between
                 * left and right to get a sum less than the target sum
                 */
                count += end - start;
                for (int j = start + 1; j <= end; j++) {
                    resultList.add(new int[]{arr[i], arr[start], arr[j]});
                }
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}
