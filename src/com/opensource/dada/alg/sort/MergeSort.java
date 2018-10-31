package com.opensource.dada.alg.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] agrs) {
        int numItems = 10;
        int[] array = new int[numItems];
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            array[i] = random.nextInt(10000);
        }
        System.out.println("Array before sort:" + Arrays.toString(array));
        long start = System.currentTimeMillis();
        sort(array);
        //improvedBubbleSort(array);
        System.out.println("Time to sort:" + (System.currentTimeMillis() - start));
        System.out.println("Array after sort:" + Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int[] tempArr = new int[array.length];
        mergeSort(array, tempArr,0, array.length - 1);
    }

    /**
     * Merge sort function
     **/
    public static void mergeSort(int arr[], int tempArr[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            /** recursively sort lower half **/
            mergeSort(arr, tempArr, low, mid);
            /** recursively sort upper half **/
            mergeSort(arr, tempArr, mid+1, high);
            merge(arr, tempArr, low, mid, high);
        }
    }

    private static void merge(int arr[], int tempArr[], int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArr[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
