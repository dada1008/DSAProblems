package com.opensource.dada.alg.dynamicprogramming;

public class MaxProfitWithKTransactions {
    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;
        //Output: 93
        System.out.println("Result:"+maxProfitWithKTransactions1(prices, k));
        System.out.println("Result:"+maxProfitWithKTransactions2(prices, k));
    }

    //Complexity time: O(nk), space: O(nk)
    static int maxProfitWithKTransactions1(int[] prices, int k){
        if (prices==null || prices.length==0) {
            return 0;
        }
        int[][] profits = new int[k+1][prices.length];
        for (int i = 1; i < k+1; i++) {
            int maxThusFor = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                maxThusFor = Math.max(maxThusFor, profits[i-1][j-1] - prices[j-1]);
                profits[i][j] = Math.max(profits[i][j-1], maxThusFor + prices[j]);
            }
        }
        return profits[profits.length-1][profits[0].length-1];
    }

    //Complexity time: O(nk), space: O(n)
    static int maxProfitWithKTransactions2(int[] prices, int k){
        if (prices==null || prices.length==0) {
            return 0;
        }
        int[] evenProfits = new int[prices.length];
        int[] oddProfits = new int[prices.length];
        int[] currentProfits = null;
        int[] previousProfits = null;
        for (int i = 1; i < k+1; i++) {
            int maxThusFor = Integer.MIN_VALUE;
            if (i%2==1) {
                currentProfits = oddProfits;
                previousProfits = evenProfits;
            } else {
                currentProfits = evenProfits;
                previousProfits = oddProfits;
            }
            for (int j = 1; j < prices.length; j++) {
                maxThusFor = Math.max(maxThusFor, previousProfits[j-1] - prices[j-1]);
                currentProfits[j] = Math.max(currentProfits[j-1], maxThusFor + prices[j]);
            }
        }
        return k%2==0? evenProfits[evenProfits.length-1]: oddProfits[oddProfits.length-1];
    }
}
