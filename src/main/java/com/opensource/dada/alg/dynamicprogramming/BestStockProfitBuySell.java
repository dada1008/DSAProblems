package com.opensource.dada.alg.dynamicprogramming;

/** Problem:
 * I grabbed Apple's stock prices from yesterday
 * and put them in a list called stock_prices, where:
 * <p>
 * The indices are the time (in minutes) past trade opening time,
 * which was 9:30am local time.
 * The values are the price (in US dollars)
 * of one share of Apple stock at that time.
 * So if the stock cost $500 at 10:30am,
 * that means stock_prices[60] = 500.
 * <p>
 * Write an efficient function that takes stock_prices
 * and returns the best profit I could have made
 * from one purchase and one sale of one share of Apple stock yesterday.
 * <p>
 * For example:
 * <p>
 * stock_prices = [10, 7, 5, 8, 11, 9]
 * <p>
 * getMaxProfit(stock_prices)
 * # Returns 6 (buying for $5 and selling for $11)
 * <p>
 * No "shorting"—you need to buy before you can sell.
 * Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 */
public class BestStockProfitBuySell {
    public static void main(String[] agrs) {

    }

    public static int getMaxProfit(int[] stock_prices) {

        if (stock_prices.length < 2) {
            throw new RuntimeException("Getting a profit requires at least 2 prices");
        }

    /*We'll greedily update min_price and max_profit, so we initialize
    them to the first price and the first possible profit*/
        int min_price = stock_prices[0];
        int max_profit = stock_prices[1] - stock_prices[0];

    /*Start at the second (index 1) time
     We can't sell at the first time, since we must buy first,
     and we can't buy and sell at the same time!
     If we started at index 0, we'd try to buy *and* sell at time 0.
     This would give a profit of 0, which is a problem if our
     max_profit is supposed to be *negative*--we'd return 0.*/
        for (int i = 1; i < stock_prices.length; i++) {
            int current_price = stock_prices[i];

        /* See what our profit would be if we bought at the
        min price and sold at the current price*/
            int potential_profit = current_price - min_price;

            /* Update max_profit if we can do better*/
            max_profit = Math.max(max_profit, potential_profit);

        /* Update min_price so it's always
         the lowest price we've seen so far*/
            min_price = Math.min(min_price, current_price);
        }
        return max_profit;
    }
}
