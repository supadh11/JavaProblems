package org.example.java.problems.arrays;
/*

121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input: prices = [7,1,5,3,6,4]
Output: 5

Solution : Although it looks like but it is not two pointer problem
Loop over array with one condition if current value is less than min. if yes, then assign current value to min
or else find the difference between current and minimum and then check if that is max then maxProfit and if yes assign it
maxProfit = Math.max(maxProfit, prices[i] - buy);
 */
public class BuySellShares {

    public static void main(String args[]){

       System.out.println( maxProfit(new int[]{1,2,2,4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy =prices[0];
        for(int i =0;i< prices.length;i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
        }


        return maxProfit;
    }

}
