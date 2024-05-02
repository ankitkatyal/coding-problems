package com.coding.problems.solutions;


/* Introduction
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack that has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an unlimited quantity of an item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.

5 Apples (total weight 5) => 75 profit
1 Apple + 2 Oranges (total weight 5) => 55 profit
2 Apples + 1 Melon (total weight 5) => 80 profit
1 Orange + 1 Melon (total weight 5) => 70 profit

This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.

Problem Statement
Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.

*/
public class P4UnboundedKnapsack {


    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer dp[][] = new Integer[profits.length][capacity+1];
        return maxProfit(dp,profits,weights,capacity,0);
    }

    public int maxProfit(Integer[][] dp,int[] profits, int[] weights, int capacity,int index){
        if(index>=profits.length || profits.length!=weights.length || capacity<=0 ){
            return 0;
        }
        if(dp[index][capacity]!=null){
            return dp[index][capacity];
        }
        int profit1 = 0;
        int profit2 = 0;
        if(weights[index]<=capacity){
            profit1 = profits[index] + maxProfit(dp,profits,weights,capacity-weights[index],index);
        }
        profit2 =  maxProfit(dp,profits,weights,capacity,index+1);
        dp[index][capacity] = Math.max(profit1,profit2);
        return dp[index][capacity];
    }

    public static void solveUnboundedKnapSack() {
        P4UnboundedKnapsack ks = new P4UnboundedKnapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
