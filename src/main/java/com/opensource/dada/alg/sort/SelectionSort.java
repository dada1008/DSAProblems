package com.opensource.dada.alg.sort;

public class SelectionSort {
    public static void main(String[] agrs) {
        int[] array = {5, 8, 3, 1, 4, 10, 9, 2, 7, 6};
        System.out.println("Array before sort:");
        printArray(array);
        sort(array);
        System.out.println("Array after sort:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;

            for (int j= i+1; j< array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
