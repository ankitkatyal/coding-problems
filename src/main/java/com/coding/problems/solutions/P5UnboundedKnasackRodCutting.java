package com.coding.problems.solutions;

/*  Problem Statement
Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit. We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.

Example:

Lengths: [1, 2, 3, 4, 5]
Prices: [2, 6, 7, 10, 13]
Rod Length: 5

Let’s try different combinations of cutting the rod:

Five pieces of length 1 => 10 price
Two pieces of length 2 and one piece of length 1 => 14 price
One piece of length 3 and two pieces of length 1 => 11 price
One piece of length 3 and one piece of length 2 => 13 price
One piece of length 4 and one piece of length 1 => 12 price
One piece of length 5 => 13 price

This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of length ‘1’.
* */
public class P5UnboundedKnasackRodCutting {

    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        Integer dp[][] = new Integer[prices.length][n+1];
        return maxProfit(dp,lengths,prices,n,0);
    }

    public int maxProfit(Integer[][] dp,int[] lengths, int[] prices, int remLength,int index){
        if(index>=lengths.length || lengths.length!=prices.length || remLength<=0 ){
            return 0;
        }
        if(dp[index][remLength]!=null){
            return dp[index][remLength];
        }
        int profit1 = 0;
        int profit2 = 0;
        if(lengths[index]<=remLength){
            profit1 = prices[index] + maxProfit(dp,lengths,prices,remLength-lengths[index],index);
        }
        profit2 =  maxProfit(dp,lengths,prices,remLength,index+1);
        dp[index][remLength] = Math.max(profit1,profit2);
        return dp[index][remLength];
    }


    public static void p5RodCuttingMain() {
        P5UnboundedKnasackRodCutting rc = new P5UnboundedKnasackRodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}
