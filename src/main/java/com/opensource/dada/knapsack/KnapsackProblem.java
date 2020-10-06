package com.opensource.dada.knapsack;

public class KnapsackProblem {
    public static void main(String[] args) {
        System.out.println("Result:"+findKnapsack(new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}}, 10));//10
    }

    static int findKnapsack(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i-1][1];
            int currentValue = items[i-1][0];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapsackValues[i][c] = knapsackValues[i-1][c];
                } else {
                    knapsackValues[i][c] = Math.max(
                            knapsackValues[i-1][c],
                            knapsackValues[i-1][c-currentWeight] + currentValue
                    );
                }
            }
        }

        return knapsackValues[knapsackValues.length -1][knapsackValues[0].length -1];
    }
}
