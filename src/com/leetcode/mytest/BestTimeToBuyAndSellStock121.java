package com.leetcode.mytest;

public class BestTimeToBuyAndSellStock121 {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock121 bt = new BestTimeToBuyAndSellStock121();
		int[] prices = new int[] {7, 6, 4, 3, 1};
		System.out.println(bt.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0], max = prices[0];
		int len = prices.length;
		int pre = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] < min) {
				int tmp = max - min;
				if (tmp > pre) {
					pre = tmp;
				}
				min = prices[i];
				max = prices[i];
			}
			else if (prices[i] > max) {
				max = prices[i];
			}
		}
		int tmp = max - min;
		if (tmp > pre) {
			pre = tmp;
		}
		return pre;
	}
}
