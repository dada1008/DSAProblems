package com.opensource.dada.alg.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] agrs) {
        int numItems =10;
        int[] array = new int[numItems];
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            array[i] = random.nextInt(10000);
        }
        System.out.println("Array before sort:"+ Arrays.toString(array));
        long start = System.currentTimeMillis();
        sort(array);
        //improvedBubbleSort(array);
        System.out.println("Time to sort:"+(System.currentTimeMillis()-start));
        System.out.println("Array after sort:"+ Arrays.toString(array));
    }

    public static void sort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    /** Quick sort function **/
    public static void quickSort(int arr[], int low, int high)
    {
        int i = low, j = high;
        int pivot = arr[(low + high) / 2];

        /** partition **/
        while (i <= j)
        {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j)
            {
                /** swap **/
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        /** recursively sort lower half **/
        if (low < j)
            quickSort(arr, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(arr, i, high);
    }
}
