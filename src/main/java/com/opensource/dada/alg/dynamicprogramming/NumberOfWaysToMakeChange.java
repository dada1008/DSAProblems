package com.opensource.dada.alg.dynamicprogramming;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println("Result:"+numberOfWaysToMakeChange(10, new int[]{1, 5, 10, 25}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] coins) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int coin: coins) {
            for (int amount = 1; amount < n +1; amount++) {
                if (coin <=amount) {
                    ways[amount] += ways[amount - coin];
                }
            }
        }
        return ways[n];
    }
}
