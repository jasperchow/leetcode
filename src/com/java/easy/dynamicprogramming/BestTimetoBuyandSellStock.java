package com.java.easy.dynamicprogramming;

public class BestTimetoBuyandSellStock {
    public BestTimetoBuyandSellStock(){ }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        else {
            int minPricePos = 0,maxProfit = 0;
            for(int i = 1;i<prices.length;i++)
            {
                if(prices[i] - prices[minPricePos] > maxProfit)
                    maxProfit = prices[i] - prices[minPricePos] ;
                else if(prices[i] - prices[minPricePos] < 0)
                    minPricePos = i;
            }
            return maxProfit;
        }
    }
}
