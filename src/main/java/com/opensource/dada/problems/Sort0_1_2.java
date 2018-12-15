package com.opensource.dada.problems;

import java.util.Arrays;

public class Sort0_1_2 {
    public static void main(String[] args) {
        int[] arr = {0, -1, 1, 1, -1, 0, 0, -1, -1, 1, 1, 0, 0};
        sort(arr);
        System.out.println("Arr: " + Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (arr[mid]) {
                case -1: {
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 0: {
                    mid++;
                    break;
                }
                case 1: {
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
