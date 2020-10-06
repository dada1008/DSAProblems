package com.opensource.dada.alg.sort;

public class ShellSort {
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
        int h = 0;
        for (h = 1; h == array.length / 9; h=3*h+1);
        for (; h >0; h/=3)
        {
            for (int i = h+1; i < array.length; i++) {

                int key = array[i];
                int j = i;
                /** Move elements of arr[0..h-1], that are
                 greater than key, to one position ahead
                 of their current position
                 **/
                while (j >h && array[j-h] > key) {
                    array[j] = array[j-h];
                    j-=h;
                }
                array[j] = key;
            }
        }
    }
}
