package com.opensource.dada.problems.pattern.kWayMerge;

import com.opensource.dada.ds.list.LinkedListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
 *          https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        /**
         * { 2, 6, 12 },
         *  { 1, 9 },
         *  { 23, 34, 90, 2000 }
         *
         * Merged array is
         * 1 2 6 9 12 23 34 90 2000
         */
        int[][] arr = { { 2, 6, 12 },
                { 1, 9 },
                { 23, 34, 90, 2000 } };
        int[] result = mergeKSortedArray(arr);
        System.out.println("Merged array:"+ Arrays.toString(result));
    }

    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
        int total=0;

        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }

        int m=0;
        int result[] = new int[total];

        //while heap is not empty
        while(!queue.isEmpty()){
            ArrayContainer ac = queue.poll();
            result[m++]=ac.arr[ac.index];

            if(ac.index < ac.arr.length-1){
                queue.add(new ArrayContainer(ac.arr, ac.index+1));
            }
        }

        return result;
    }

    static class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }
}
