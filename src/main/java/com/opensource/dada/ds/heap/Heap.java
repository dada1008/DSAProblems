package com.opensource.dada.ds.heap;

import java.util.Arrays;
import java.util.Random;

public class Heap {

    public static void main(String[] agrs) {
        int numItems =10;
        Random random = new Random();
        Heap heap = new Heap(numItems);
        for (int i = 0; i < numItems; i++) {
            int value = random.nextInt(10000);
            heap.insert(value);
        }
        System.out.println("Array heap:"+ Arrays.toString(heap.heapArray));
        /*heap.remove();
        System.out.println("2 Array heap:"+ Arrays.toString(heap.heapArray));
        heap.remove();
        System.out.println("3 Array heap:"+ Arrays.toString(heap.heapArray));
        */
    }

    int[] heapArray;
    int size;
    public Heap(int maxSize) {
        this.heapArray = new int[maxSize];
    }

    public void insert(int value) {
        heapArray[size++] = value;
        // Start at the new item and work up to the root.
        int index = size -1;
        while (index != 0)
        {
            // Find the parent's index.
            int parent = (index - 1) / 2;

            // If child <= parent, we're done so
            // break out of the while loop.
            if (heapArray[index] <= heapArray[parent]) break;

            // Swap the parent and child.
            int temp = heapArray[index];
            heapArray[index] = heapArray[parent];
            heapArray[parent] = temp;

            // Move to the parent.
            index = parent;
        }

    }
    // Use heapsort to sort the array.
    private void heapSort(int[] values)
    {
        // Make the array into a heap.
        /*for (int i=0;i<values.length;i++) {
            insert(values[i]);
        }

        // Pop items from the root to the end of the array.
        for (int i = values.length - 1; i > 0; i--)
        {
            // Remove the top item and restore the heap property.
            int value = remove(values, i + 1);

            // Save the top item past the end of the tree.
            values[i] = value;
        }*/

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
    private void makeHeap(int[] values)
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
    private int removeTopItem(int[] values, int count)
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

    public int remove(int[] values, int count) {
        int result = values[0];
        // Save the top item to return later.
        values[0]= values[count-1];
        int index = 0;
        while (true) {
            int child1 = 2*index +1;
            int child2 = 2*index +2;

            if(child1 >=index) {
                child1 = index;
            }

            if(child2 >=index) {
                child2 = index;
            }
            // If heap property is satisfied, we are done, so break out of the while loop
            if (values[index]>=values[child1] && values[index]>=values[child2]) {
                break;
            }

            // Get the index of the child with larger value.
            int swapChild;

            if (values[child1] > values[child2]) {
                swapChild = child1;
            } else {
                swapChild = child2;
            }

            // Swap the parent and child.
            int temp = values[index];
            values[index] = values[swapChild];
            values[swapChild] = temp;

            // Move to the parent.
            index = swapChild;
        }
        return result;
    }

    public int remove() {
        int result = heapArray[0];
        // Save the top item to return later.
        heapArray[0]= heapArray[--size];
        int index = 0;
        while (true) {
            int child1 = 2*index +1;
            int child2 = 2*index +2;

            if(child1 >=index) {
                child1 = index;
            }

            if(child2 >=index) {
                child2 = index;
            }
            // If heap property is satisfied, we are done, so break out of the while loop
            if (heapArray[index]>=heapArray[child1] && heapArray[index]>=heapArray[child2]) {
                break;
            }

            // Get the index of the child with larger value.
            int swapChild;

            if (heapArray[child1] > heapArray[child2]) {
                swapChild = child1;
            } else {
                swapChild = child2;
            }

            // Swap the parent and child.
            int temp = heapArray[index];
            heapArray[index] = heapArray[swapChild];
            heapArray[swapChild] = temp;

            // Move to the parent.
            index = swapChild;
        }
        return result;
    }
}
