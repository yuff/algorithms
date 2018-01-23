package com.leetcode.mytest;

public class SpiralMatrixII {
	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		int n = 6;
		int[][] result = sm.generateMatrix(n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(result[i][j] + ",");
			}
			System.out.println();
		}
	}
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int[][] result = new int[n][n];
		int start = 1;
		for (int i = 0; i < n; i++) {
			start = generateMatrix(result, i, start);
		}
		return result;
	}

	private int generateMatrix(int[][] result, int i, int start) {
		int n = result.length;
		if (i % 2 == 0) {
			int cs = i >> 1, rs = cs, end = n - 1 - rs;
			while (cs <= end) {
				result[rs][cs] = start++;
				cs++;
			}
			rs++;
			while (rs <= end) {
				result[rs][end] = start++;
				rs++;
			}
		} else {
			int rs = n - 1 - (i >> 1),cs = rs - 1, ce = i >> 1, re = ce + 1;
			while (cs >=  ce) {
				result[rs][cs] = start++;
				cs--;
			}
			rs--;
			while (rs >= re) {
				result[rs][ce] = start++;
				rs--;
			}
		}
		return start;
	}
}
