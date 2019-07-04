package com.opensource.dada.problems;

/**
 * Problem: https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
 */
public class MedianOfTwoSortedArrays {
    // Function to find max
    static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    // Function to find minimum
    static int minimum(int a, int b) {
        return a < b ? a : b;
    }

    // Function to find median of two sorted arrays
    static double findMedianSortedArrays(int[] a, int[] b) {
        int min_index = 0, max_index = a.length, i = 0, j = 0, median = 0;

        while (min_index <= max_index) {
            i = (min_index + max_index) / 2;
            j = ((a.length + b.length + 1) / 2) - i;

            // if i = n, it means that Elements
            // from a[] in the second half is an
            // empty set. and if j = 0, it means
            // that Elements from b[] in the first
            // half is an empty set. so it is
            // necessary to check that, because we
            // compare elements from these two
            // groups. Searching on right
            if (i < a.length && j > 0 && b[j - 1] > a[i]) {
                min_index = i + 1;

                // if i = 0, it means that Elements
                // from a[] in the first half is an
                // empty set and if j = m, it means
                // that Elements from b[] in the second
                // half is an empty set. so it is
                // necessary to check that, because
                // we compare elements from these two
                // groups. searching on left
            } else if (i > 0 && j < b.length && b[j] < a[i - 1]) {
                max_index = i - 1;
                // we have found the desired halves.
            } else {
                // this condition happens when we
                // don't have any elements in the
                // first half from a[] so we
                // returning the last element in
                // b[] from the first half.
                if (i == 0) {
                    median = b[j - 1];

                    // and this condition happens when
                    // we don't have any elements in the
                    // first half from b[] so we
                    // returning the last element in
                    // a[] from the first half.
                } else if (j == 0) {
                    median = a[i - 1];
                } else {
                    median = maximum(a[i - 1],
                            b[j - 1]);
                }
                break;
            }
        }

        // calculating the median.
        // If number of elements is odd
        // there is one middle element.
        if ((a.length + b.length) % 2 == 1) {
            return (double) median;
        }

        // Elements from a[] in the
        // second half is an empty set.
        if (i == a.length) {
            return (median + b[j]) / 2.0;
        }

        // Elements from b[] in the
        // second half is an empty set.
        if (j == b.length) {
            return (median + a[i]) / 2.0;
        }

        return (median + minimum(a[i],
                b[j])) / 2.0;
    }

    // Driver code
    public static void main(String args[]) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] a = new int[]{900};
        int[] b = new int[]{10, 13, 14};
        //output 13.5
        // we need to define the
        // smaller array as the
        // first parameter to
        // make sure that the
        // time complexity will
        // be O(log(min(n,m)))
        if (a.length < b.length) {
            System.out.println("The median is : " +
                    findMedianSortedArrays(a, b));
        } else {
            System.out.println("The median is : " +
                    findMedianSortedArrays(b, a));
        }
    }

    public static void test2() {
        int[] a = new int[]{2, 3, 5, 8};
        int[] b = new int[]{10, 12, 14, 16, 18, 20};
        //output 11
        if (a.length < b.length) {
            System.out.println("The median is : " +
                    findMedianSortedArrays(a, b));
        } else {
            System.out.println("The median is : " +
                    findMedianSortedArrays(b, a));
        }
    }

    public static void test3() {
        int[] a = new int[]{-5, 3, 6, 12, 15};
        int[] b = new int[]{-12, -10, -6, -3, 4, 10};
        //output 3
        if (a.length < b.length) {
            System.out.println("The median is : " +
                    findMedianSortedArrays(a, b));
        } else {
            System.out.println("The median is : " +
                    findMedianSortedArrays(b, a));
        }
    }
}
