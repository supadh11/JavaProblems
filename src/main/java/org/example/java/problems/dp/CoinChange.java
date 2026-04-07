package org.example.java.problems.dp;

import java.util.Arrays;

/*
322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1

Solution :
In this solution we will use memoization of amounts. We will manage an array of each amount lesser than target.
We will incrementally add values to the array.
so basically while we are finding array[i - coins[j]], it means we are subtracting coin value out of the amount and then adding 1 for counting the coin.
in the end we are storing the minimum value in the array for that amount.

Once both the loop ends it checks if array[amount] stores originally assigned value or any other value.
if it's different the value is returned or else -1 is returned.

 */
public class CoinChange {

    public static void main(String args[]){
        int[] coins = {1,2,5};
        System.out.print(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] array = new int[amount+1];
        Arrays.fill(array,amount+1);
        array[0] = 0;

            for(int i = 1;i<= amount;i++){
                for(int j =0;j<coins.length;j++){
                    if(i - coins[j] >= 0){
                       array[i] = Math.min(array[i], array[i-coins[j]]+1);
                    }
            }
        }

        return (array[amount] != amount+1) ? array[amount] : -1;
    }




}
