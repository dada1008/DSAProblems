package com.opensource.dada.ds.graph;

import java.util.stream.IntStream;

/**
 * Problem:
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * https://www.baeldung.com/java-sudoku
 *
 * Solution -
 * https://github.com/eugenp/tutorials/tree/master/algorithms-miscellaneous-2/src/main/java/com/baeldung/algorithms/sudoku
 */
public class Sudoku {
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        solve(board);
        System.out.println("Test 1:");
        printBoard(board);
        /**
         * Output:
         * 8 1 2 7 5 3 6 4 9
         * 9 4 3 6 8 2 1 7 5
         * 6 7 5 4 9 1 2 8 3
         * 1 5 4 2 3 7 8 9 6
         * 3 6 9 8 4 5 7 2 1
         * 2 8 7 1 6 9 5 3 4
         * 5 2 1 9 7 4 3 6 8
         * 4 3 8 5 2 6 9 1 7
         * 7 9 6 3 1 8 4 5 2
         */
    }

    private static void test2() {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solve(board);
        System.out.println("Test 2:");
        printBoard(board);
        /**
         * Output:
         *   3 1 6 5 7 8 4 9 2
         *   5 2 9 1 3 4 7 6 8
         *   4 8 7 6 2 9 5 3 1
         *   2 6 3 4 1 5 9 8 7
         *   9 7 4 8 6 3 1 2 5
         *   8 5 1 7 9 2 6 4 3
         *   1 3 8 9 4 7 2 5 6
         *   6 9 2 3 5 1 8 7 4
         *   7 4 5 2 8 6 3 1 9
         */
    }

    private static void test3() {
        int[][] board = {
                { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                { 7, 4, 5, 0, 8, 6, 3, 1, 0 }
        };
        solve(board);
        System.out.println("Test 3:");
        printBoard(board);
        /**
         * Output:
         * 3 1 6 5 7 8 4 9 2
         * 5 2 9 1 3 4 7 6 8
         * 4 8 7 6 2 9 5 3 1
         * 2 6 3 4 1 5 9 8 7
         * 9 7 4 8 6 3 1 2 5
         * 8 5 1 7 9 2 6 4 3
         * 1 3 8 9 4 7 2 5 6
         * 6 9 2 3 5 1 8 7 4
         * 7 4 5 2 8 6 3 1 9
         */
    }

    static void printBoard(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    static boolean solve(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int[][] board, int row, int column) {
        return rowConstraint(board, row) &&
                columnConstraint(board, column) &&
                subsectionConstraint(board, row, column);
    }

    static boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    static boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    static boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
