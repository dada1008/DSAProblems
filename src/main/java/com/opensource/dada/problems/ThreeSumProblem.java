package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Problem:
 *
 */
public class ThreeSumProblem {
    public static void main(String[] args) {
        List<int[]> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("Result:");
        for (int[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static List<int[]> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();

        for (int i=0;i<arr.length-3; i++) {
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
