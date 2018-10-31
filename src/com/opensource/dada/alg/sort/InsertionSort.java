package com.opensource.dada.alg.sort;

public class InsertionSort {
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
            int key = array[i];
            int j = i - 1;
            /** Move elements of arr[0..i-1], that are
             greater than key, to one position ahead
             of their current position
             **/
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
