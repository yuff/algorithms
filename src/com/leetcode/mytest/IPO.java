package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class IPO {
	public static void main(String[] args) {
		IPO ipo = new IPO();
		int num = 50000;
		int[] nums = new int[num];
		for (int i = 0; i < num; i++) {
			nums[i] = i;
		}
		System.out.println(ipo.findMaximizedCapital(num, num, nums, nums));
		System.out.println(ipo.findMaximizedCapital(10, 0, new int[] {1, 2, 3}, new int[] {0, 1, 2}));
		System.out.println(ipo.findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {0, 1, 1}));
		System.out.println(ipo.findMaximizedCapital(3, 0, new int[] {1, 2, 3}, new int[] {0, 1, 2}));
		System.out.println(ipo.findMaximizedCapital(11, 11, new int[] {1, 2, 3}, new int[] {11, 12, 13}));
		System.out.println(ipo.findMaximizedCapital(2, 1, new int[] {1, 2, 3}, new int[] {0, 1, 1}));
	}

	class CP {
		CP(int profit, int capital) {
			this.profit = profit;
			this.capital = capital;
		}

		int profit;
		int capital;
	}

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		if (k == 0 || Profits == null || Profits.length == 0 || Capital == null || Capital.length != Profits.length) {
			return W;
		}
		int len = Profits.length;
		boolean[] picked = new boolean[len];
		CP[] cp = new CP[len];
		int sumProfit = W, maxCapital = 0;;
		for (int i = 0; i < len; i++) {
			cp[i] = new CP(Profits[i], Capital[i]);
			sumProfit += Profits[i];
			if (Capital[i] > maxCapital) {
				maxCapital = Capital[i];
			}
		}
		Arrays.sort(cp, new Comparator<CP>() {
			@Override
			public int compare(CP o1, CP o2) {
				if (o1.profit == o2.profit) {
					return o1.capital - o2.capital;
				}
				return o2.profit - o1.profit;
			}
		});
		int sum = W;
		if (k >= len) {
			if (sum >= maxCapital) {
				return sumProfit;
			}
			else {
				int i = 1;
				while (i <= len) {
					for (int j = 0; j < len; j++) {
						if (sum >= cp[j].capital && !picked[j]) {
							sum += cp[j].profit;
							picked[j] = true;
							break;
						}
					}
					if (sum >= maxCapital) {
						return sumProfit;
					}
					i++;
				}
				return sum;
			}
		}
		else {
			int i = 1;
			while (i <= k) {
				for (int j = 0; j < len; j++) {
					if (sum >= cp[j].capital && !picked[j]) {
						sum += cp[j].profit;
						picked[j] = true;
						break;
					}
				}
				i++;
			}
			return sum;
		}
	}
}
