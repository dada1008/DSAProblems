package com.opensource.dada.problems.pattern.bitwise.xor;

/**
 * Problem:
 * <p>
 * Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [0, 1, 1] horizontally results in [1, 1, 0].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [1, 1, 0] results in [0, 0, 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [
 * [1,0,1],
 * [1,1,1],
 * [0,1,1]
 * ]
 * Output: [
 * [0,1,0],
 * [0,0,0],
 * [0,0,1]
 * ]
 * Explanation: First reverse each row: [[1,0,1],[1,1,1],[1,1,0]].
 * Then, invert the image: [[0,1,0],[0,0,0],[0,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: [
 * [1,1,0,0],
 * [1,0,0,1],
 * [0,1,1,1],
 * [1,0,1,0]
 * ]
 * Output: [
 * [1,1,0,0],
 * [0,1,1,0],
 * [0,0,0,1],
 * [1,0,1,0]
 * ]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * Solution
 * Flip: We can flip the image in place by replacing ith element from left
 * with the ith element from the right.
 * <p>
 * Invert: We can take XOR of each element with 1.
 * If it is 1 then it will become 0 and if it is 0 then it will become 1.
 */
public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage3(arr));
        System.out.println();
        int[][] arr2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        print(flipAndInvertImage3(arr2));
    }

    public static int[][] flipAndInvertImage(int[][] arr) {
        int col = arr[0].length;
        for (int[] row : arr) {
            for (int i = 0; i < (col + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[col - 1 - i] ^ 1;
                row[col - 1 - i] = temp;
            }
        }
        return arr;
    }

    //My solution
    public static int[][] flipAndInvertImage2(int[][] arr) {
        int col = arr[0].length - 1;
        //flip
        for (int[] row : arr) {
            for (int i = 0; i <= (col) / 2; i++) {
                int temp = row[i];
                row[i] = row[col - i];
                row[col - i] = temp;
            }
        }

        //Invert
        for (int[] row : arr) {
            for (int i = 0; i <= col; i++) {
                row[i] = getInverted(row[i]);
            }
        }
        return arr;
    }

    //My solution improved
    public static int[][] flipAndInvertImage3(int[][] arr) {
        int col = arr[0].length - 1;

        for (int[] row : arr) {
            for (int i = 0; i <= (col) / 2; i++) {
                //flip
                int temp = getInverted(row[i]);//Invert
                row[i] = getInverted(row[col - i]);//Invert
                row[col - i] = temp;
            }
        }
        return arr;
    }

    static int getInverted(int num) {
        if (num == 1) {
            return 0;
        }
        return 1;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
