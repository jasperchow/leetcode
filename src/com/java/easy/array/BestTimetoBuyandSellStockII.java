//Say you have an array prices for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//        Example 1:
//
//        Input: [7,1,5,3,6,4]
//        Output: 7
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

package com.java.easy.array;

public class BestTimetoBuyandSellStockII {

    public BestTimetoBuyandSellStockII(){}

    public int maxProfit_v1(int[] prices) {
        int valley;
        int peak;
        int i = 0;
        int result = 0;
        while(i < prices.length - 1)
        {
            while(prices[i] >= prices[i + 1] && i < prices.length - 1){
                i ++;
            }
            valley = prices[i];
            while (prices[i] <= prices[i + 1] && i < prices.length - 1){
                i ++;
            }
            peak = prices[i];
            result += peak - valley;
        }
        return result;
    }

    public int maxProfit_v2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

}
