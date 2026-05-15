package org.example.java.problems.dp;
/*
123. Best Time to Buy and Sell Stock III
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Solution :

manage four states for each element : buy1,profit1, buy2, profit2. take the max of both of them.
start with -prices as we dont have any money.
| Price | buy1 | profit1 | buy2 | profit2 |
| ----- | ---- | ----- | ---- | ----- |
| 3     | -3   | 0     | -3   | 0     |
| 3     | -3   | 0     | -3   | 0     |
| 5     | -3   | 2     | -3   | 2     |
| 0     | 0    | 2     | 2    | 2     |
| 0     | 0    | 2     | 2    | 2     |
| 3     | 0    | 3     | 2    | 5     |
| 1     | 0    | 3     | 2    | 5     |
| 4     | 0    | 4     | 2    | 6     |

 */
public class BestTimeToBuyAnsSellStock {

    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{1,2,3,4,0,1,4}));
    }

    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int profit1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int profit2 = 0;
        for(int i =0;i<prices.length;i++){
            buy1 = Math.max(buy1,  -prices[i]);
            profit1 = Math.max(profit1, buy1 + prices[i]);
            buy2 = Math.max(buy2, profit1 - prices[i]);
            profit2 = Math.max(profit2, buy2+prices[i]);
        }

        return profit2;
    }
}
