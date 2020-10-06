package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * Problem:
 * What is the size of each river found in the matrix, river is nothing but continuous 1's ?
 *
 * For example, given the matrix:
 *
 * The number of rivers is 5.
 * [
 *   [1, 0, 0, 1, 0],
 *   [1, 0, 1, 0, 0],
 *   [0, 0, 1, 0, 1],
 *   [1, 0, 1, 0, 1],
 *   [1, 0, 1, 1, 0]
 * ]
 * The number of river sizes is [1,2,2,2,5].
 */
public class RiverSizesProblem {
    public static void main(String[] args) {
        int[][] map1 = {
                {1, 3, 3, 3},
                {1, 2, 4, 3},
                {2, 3, 4, 4},
        };
        int[][] map2 = {
                {1, 0, 0, 1, 0},
                { 1, 0, 1, 0, 0},
                { 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        int [][] A = new int[7][3];
        A[0][0] = 5; A[0][1] = 4; A[0][2] = 4;
        A[1][0] = 4; A[1][1] = 3; A[1][2] = 4;
        A[2][0] = 3; A[2][1] = 2; A[2][2] = 4;
        A[3][0] = 2; A[3][1] = 2; A[3][2] = 2;
        A[4][0] = 3; A[4][1] = 3; A[4][2] = 4;
        A[5][0] = 1;    A[5][1] = 4;    A[5][2] = 4;
        A[6][0] = 4;    A[6][1] = 1;    A[6][2] = 1;
        System.out.println("map1 countries:"+ riverSizes(map1));
        System.out.println("map2 countries:"+ riverSizes(map2));
        System.out.println("A countries:"+ riverSizes(A));
    }
    static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (visited[i][j]) {
                    continue;
                }
                traverseNodes(matrix, i, j, visited, sizes);
            }
        }
        // update our display of the country count:
        return sizes;
    }

    static void traverseNodes(int[][] matrix, int i, int j, boolean[][] visited, List<Integer> sizes) {
        if (i < 0 || i >= matrix.length) {
            return;
        }
        if (j < 0 || j >= matrix[0].length) {
            return;
        }
        int currentRiverSize = 0;
        Stack<int[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new int[] {i,j});
        while (!nodesToExplore.isEmpty()) {
            int[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j]=true;
            if (matrix[i][j]==0) {
                continue;
            }
            currentRiverSize +=1;
            nodesToExplore.addAll(unVisitedNeighbours(matrix, i, j, visited));
        }
        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    private static Collection<? extends int[]> unVisitedNeighbours(int[][] matrix, int i, int j, boolean[][] visited) {
        List<int[]> list = new ArrayList<>();
        if (i > 0 && !visited[i-1][j]) {
            list.add(new int[]{i-1, j});
        }
        if (i < matrix.length-1 && !visited[i+1][j]) {
            list.add(new int[]{i+1, j});
        }
        if (j > 0 && !visited[i][j-1]) {
            list.add(new int[]{i, j-1});
        }
        if (j < matrix[0].length-1 && !visited[i][j+1]) {
            list.add(new int[]{i, j+1});
        }
        return list;
    }

}
