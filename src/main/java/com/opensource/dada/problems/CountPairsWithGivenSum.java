package com.opensource.dada.problems;

import java.util.*;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    public static void test1() {
        List<int[]> result = findPairsWithGivenSum(new int[]{1, 5, 7, -1}, 6);
        printResult(result);
    }
    public static void test2() {
        List<int[]> result = findPairsWithGivenSum(new int[]{1, 5, 7, -1, 5}, 6);
        printResult(result);
    }
    public static void test3() {
        List<int[]> result = findPairsWithGivenSum(new int[]{1, 1, 1, 1}, 2);
        printResult(result);
    }
    public static void test4() {
        List<int[]> result = findPairsWithGivenSum(new int[]{10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1}, 11);
        printResult(result);
    }
    private static void printResult(List<int[]> result) {
        System.out.println("Total pairs: "+(result.size())+" Result:");
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
    static List<int[]> findPairsWithGivenSum(int[] arr, int sum) {
        //return solutionWithSort(arr,sum);
        return solutionWithMap(arr,sum);
    }

    static List<int[]> solutionWithSort(int[] arr, int sum) {
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();

        int start = 0;
        int end = arr.length - 1;
        int curStart = start;
        int curEnd = end;
        while (curStart< curEnd) {
            int tempSum = arr[curStart] + arr[curEnd];
            if (sum == tempSum) {
                resultList.add(new int[]{arr[curStart], arr[curEnd]});
                curStart++;
            } else if (sum < tempSum) {
                curStart++;
            } else {
                curEnd--;
            }
        }
        return resultList;
    }

    static List<int[]> solutionWithMap(int[] arr, int sum) {
        List<int[]> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i])+1);
        }

        for (int i=0; i<arr.length; i++) {
            int rem = sum-arr[i];
            if(map.containsKey(rem)) {
                int loop = map.get(rem);
                for(int j=0; j<loop; j++) {
                    resultList.add(new int[]{rem, arr[i]});
                }
            }
        }

        return resultList;
    }
}