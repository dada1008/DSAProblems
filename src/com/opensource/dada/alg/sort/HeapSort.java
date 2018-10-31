package com.opensource.dada.alg.sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] agrs) {
        int numItems =50000;
        int[] input = new int[numItems];
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            input[i] = random.nextInt(100000);
        }
        long start = System.currentTimeMillis();
        //Slower
        //heapSort(input);
        //Faster
        sort(input);
        System.out.println("time:"+ (System.currentTimeMillis() - start));
        System.out.println("sort:"+ Arrays.toString(input));

    }

    public static void heapSort(int[] values)
    {
        // Make the array into a heap.
        makeHeap(values);

        // Pop items from the root to the end of the array.
        for (int i = values.length - 1; i > 0; i--)
        {
            // Remove the top item and restore the heap property.
            int value = removeTopItem(values, i + 1);

            // Save the top item past the end of the tree.
            values[i] = value;
        }
    }

    // Make the array into a heap.
    private static void makeHeap(int[] values)
    {
        // Add each item to the heap one at a time.
        for (int i = 0; i < values.length; i++)
        {
            // Start at the new item and work up to the root.
            int index = i;
            while (index != 0)
            {
                // Find the parent's index.
                int parent = (index - 1) / 2;

                // If child <= parent, we're done so
                // break out of the while loop.
                if (values[index] <= values[parent]) break;

                // Swap the parent and child.
                int temp = values[index];
                values[index] = values[parent];
                values[parent] = temp;

                // Move to the parent.
                index = parent;
            }
        }
    }

    // Remove the top item from a heap with
    // count items and restore its heap property.
    private static int removeTopItem(int[] values, int count)
    {
        // Save the top item to return later.
        int result = values[0];

        // Move the last item to the root.
        values[0] = values[count - 1];

        // Restore the heap property.
        int index = 0;
        for (; ; )
        {
            // Find the child indices.
            int child1 = 2 * index + 1;
            int child2 = 2 * index + 2;

            // If a child index is off the end of the tree,
            // use the parent's index.
            if (child1 >= count) child1 = index;
            if (child2 >= count) child2 = index;

            // If the heap property is satisfied, we're done.
            if ((values[index] >= values[child1]) &&
                    (values[index] >= values[child2])) break;

            // Get the index of the child with the larger value.
            int swapChild;
            if (values[child1] > values[child2])
                swapChild = child1;
            else
                swapChild = child2;

            // Swap with the larger child.
            int temp = values[index];
            values[index] = values[swapChild];
            values[swapChild] = temp;

            // Move to the child node.
            index = swapChild;
        }

        // Return the value we removed from the root.
        return result;
    }

    public static void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
