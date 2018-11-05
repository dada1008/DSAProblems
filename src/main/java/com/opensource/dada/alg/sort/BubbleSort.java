package com.opensource.dada.alg.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] agrs) {
        int numItems =5000;
        int[] array = new int[numItems];
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            array[i] = random.nextInt(10000);
        }
        System.out.println("Array before sort:"+ Arrays.toString(array));
        long start = System.currentTimeMillis();
        //sort(array);
        improvedBubbleSort(array);
        System.out.println("Time to sort:"+(System.currentTimeMillis()-start));
        System.out.println("Array after sort:"+ Arrays.toString(array));
    }

    public static void sort(int[] array) {
        // Repeat until the array is sorted.
        boolean notSorted = true;
        while (notSorted)
        {
            // Assume there will be no swap during this pass.
            notSorted = false;

            // Examine the array to see if any two
            // adjacent items are out of order.
            for (int i = 1; i < array.length; i++)
            {
                // See if items i and i - 1 are out of order.
                if (array[i] < array[i - 1])
                {
                    // Swap them.
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    notSorted = true;
                }
            }
        }
    }
    public static void improvedBubbleSort(int[] values) {

        // Bounds for the items that are not yet sorted.
        int imin = 0;
        int imax = values.length - 1;

        // Repeat until the array is sorted.
        while (imin < imax)
        {
            // Record the index of the last swapped item.
            int lastSwap = imin;

            // Downward pass.
            for (int i = imin; i < imax; i++)
            {
                // See if items i and i + 1 are out of order.
                if (values[i] > values[i + 1])
                {
                    // Swap them.
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;

                    // Update the index of the last swapped item.
                    lastSwap = i;
                }
            }

            // Update imax.
            imax = lastSwap;

            // See if we're done.
            if (imin >= imax) break;

            // Upward pass.
            lastSwap = imax;
            for (int i = imax; i > imin; i--)
            {
                // See if items i and i - 1 are out of order.
                if (values[i] < values[i - 1])
                {
                    // Swap them.
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;

                    // Update the index of the last swapped item.
                    lastSwap = i;
                }
            }

            // Update imin.
            imin = lastSwap;
        }

    }
}
