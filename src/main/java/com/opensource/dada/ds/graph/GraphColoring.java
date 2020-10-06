package com.opensource.dada.ds.graph;

import java.util.Arrays;

/**
 * Problem: https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
 * <p>
 * Given an undirected graph represented as an adjacency matrix and an integer k,
 * determine whether each node in the graph can be colored such that
 * no two adjacent nodes share the same color using at most k colors.
 */
public class GraphColoring {

    /* This function solves the m Coloring problem using recursion. It returns
  false if the m colors cannot be assigned, otherwise return true and
  prints assignments of colors to all vertices. Please note that there
  may be more than one solutions, this function prints one of the
  feasible solutions.*/
    private static boolean graphColoring(boolean[][] graph, int m, int i, int[] color) {
        //if current index reached end
        if (i == V) {
            //if coloring is safe
            if (isSafe(graph, color)) {
                // Print the solution
                printSolution(color);
                return true;
            }
            return false;
        }

        //assign each color from 1 to m
        for (int j = 1; j <= m; j++) {
            color[i] = j;

            //recur of the rest vertices
            if (graphColoring(graph, m, i + 1, color))
                return true;

            color[i] = 0;
        }

        return false;
    }

    //check if the colored graph is safe or not
    static boolean isSafe(boolean[][] graph, int[] color) {
        //check for every edge
        for (int i = 0; i < V; i++)
            for (int j = i + 1; j < V; j++)
                if (graph[i][j] && color[j] == color[i])
                    return false;
        return true;
    }

    /* A utility function to print solution */
    static void printSolution(int color[]) {
        System.out.println("Solution Exists: Following are the assigned colors \n");
        for (int i = 0; i < V; i++)
            System.out.print(color[i] + " ");
        System.out.println("\n");
    }

    static int V = 4;

    public static void main(String[] args) {
/* Create following graph and test whether it is 3 colorable
      (3)---(2)
       |   / |
       |  /  |
       | /   |
      (0)---(1)
    */
        boolean graph[][] = new boolean[][]{
                {
                        false, true, true, true
                },
                {
                        true, false, true, false
                },
                {
                        true, true, false, true
                },
                {
                        true, false, true, false
                },
        };
        int m = 3; // Number of colors

        // Initialize all color values as 0. This initialization is needed
        // correct functioning of isSafe()
        int color[] = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (!graphColoring(graph, m, 0, color))
            System.out.println("Solution does not exist");

        //Using backtracking
        nColors = 3;
        connected = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
        };
        nNodes = connected.length-1;
        colors = new int[nNodes+1];

        mColoring(1);
    }

    /**
     * using Backtracking
     */

    static int connected[][];
    static int[] colors;
    static int nColors;
    static int nNodes;

    static int getNodeColor(int k) {
        do {
            int j;
            //Assign the next color
            colors[k] = colors[k] + 1;

            //If all colors have been tested on this node,
            //return because there are no more new colors left
            //to be considered for this node
            if (colors[k] == nColors + 1) return 0;

            //Check to see if some connected node already has this color
            for (j = 1; j <= nNodes; ++j) {
                if (connected[k][j] == 1 && colors[k] == colors[j] && k != j) {
                    break;
                }
            }
            if (j == nNodes + 1) return colors[k];
        } while (true);
    }

    static void mColoring(int k) {
        do {
            //get a color for this node
            colors[k] = getNodeColor(k);

            //if no more colors can be applied to this node, return
            if (colors[k] == 0) return;

            //if all the nodes have been assigned colors successfully, print the color assignments
            if (k == nNodes) {
                System.out.println("Color Assignment: " + Arrays.toString(colors));
                //return /*don't quit until all possible assignments have been found*/
            }
            //consider the next node
            else mColoring(k + 1);
        } while (true);
    }

}
