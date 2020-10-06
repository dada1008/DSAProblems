package com.opensource.dada.problems;

import java.util.Arrays;

/**
 * Problem:
 *
 * Search a number in sorted matrix, row and column are sorted in ascending order
 */
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };
        System.out.println("Result:"+ Arrays.toString(search(matrix, 44)));
    }

    // Time complexity: O(n + m), where n is no. of rows and m is n. of columns; Space complexity: O(1)
    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col -= 1;
            } else if (matrix[row][col] < target) {
                row += 1;
            } else {
                return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }
}
