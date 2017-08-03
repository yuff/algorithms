package com.leetcode.mytest;

public class BestTimeBuyAndSellStockII {
	public static void main(String[] args) {
		BestTimeBuyAndSellStockII bt = new BestTimeBuyAndSellStockII();
		int[] prices = new int[] {1,4};
		System.out.println(bt.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int result = 0;
		int min = 0, max = 0;
		int n = prices.length;
		for (int i = 1; i < n; i++) {
			if (max != -1) {
				if (prices[i] >= prices[max]) {
					max = i;
				}
				else {
					if (min != -1) {
						result += (prices[max] - prices[min]);
					}
					max = -1;
					min = i;
				}
			}
			else {
				if (prices[i] <= prices[min]) {
					min = i;
				}
				else {
					max = i;
				}
			}
		}
		if (min != -1 && max != -1 && min < max) {
			result += (prices[max] - prices[min]);
		}
		return result;
	}
}
