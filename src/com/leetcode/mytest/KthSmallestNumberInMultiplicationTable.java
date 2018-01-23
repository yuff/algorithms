package com.leetcode.mytest;

public class KthSmallestNumberInMultiplicationTable {
	public static void main(String[] args) {
		KthSmallestNumberInMultiplicationTable ks = new KthSmallestNumberInMultiplicationTable();
		int m = 45, n = 12;
		int[][] nums = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = (i + 1) * (j + 1);
			}
		}
		// System.out.println(ks.findKthNumber(6, 7, 13) == ks.findKthNumber1(6, 7, 13));
		System.out.println(ks.findKthNumber(45, 12, 471));

	}

	public int findKthNumber(int m, int n, int k) {
		int max = m * n + 1, min = 1;
		while (min < max) {
			int mid = (max + min) >> 1;
			int c = countNumber(m, n, mid);
			if (c >= k) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		return max;
	}

	private int countNumber(int m, int n, int mid) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min(mid / i, n);
		}
		return count;
	}

	public int findKthNumber1(int m, int n, int k) {
		if (k == 1) {
			return 1;
		}
		if (k == m * n) {
			return m * n;
		}
		int total = m * n, result = -1, count = 0;
		for (int i = 1; i <= total; i++) {
			count += countOfNum(i, m, n);
			if (count >= k) {
				result = i;
				break;
			}
		}
		return result;
	}

	private int countOfNum(int num, int m, int n) {
		int result = 0;
		for (int i = m; i >= 1; i--) {
			if (num % i == 0) {
				int a = num / i;
				if (a <= n) {
					result++;
				}
				else {
					break;
				}
			}
		}
		return result;
	}
}
