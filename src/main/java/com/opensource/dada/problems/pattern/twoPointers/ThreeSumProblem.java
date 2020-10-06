package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Problem:
 *
 */
public class ThreeSumProblem {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        List<int[]> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("Result:");
        for (int[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void test2() {
        List<int[]> result = threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2});
        System.out.println("Result:");//[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        for (int[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void test3() {
        List<int[]> result = threeSum(new int[]{-5, 2, -1, -2, 3});
        System.out.println("Result:");//[-5, 2, 3], [-2, -1, 3]
        for (int[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static List<int[]> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();

        for (int i=0;i<arr.length-2; i++) {
            int start = i+1;
            int end = arr.length-1;
            while (start<end) {
                int sum = arr[i]+arr[start]+arr[end];
                if(sum==0) {
                    resultList.add(new int[]{arr[i],arr[start],arr[end]});
                    start++;
                    end--;
                } else if (sum<0) {
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
        return resultList;
    }
}
