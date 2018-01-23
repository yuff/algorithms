package com.leetcode.mytest;

public class BestTimeStockCooldown309 {
	public static void main(String[] args) {
		BestTimeStockCooldown309 bts = new BestTimeStockCooldown309();
		System.out.println(bts.maxProfit(new int[] {1, 2, 3, 0, 2, 4}));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		buy[0] = -prices[0];
		sell[0] = 0;
		for (int i = 1; i < n; i++) {
			sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
			if (i > 1) {
				buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			}
			else {
				buy[i] = Math.max(buy[i - 1], -prices[i]);
			}
		}
		return sell[n - 1];
	}
}
