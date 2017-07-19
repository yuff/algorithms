package com.leetcode.mytest.dynamicprogramming;

public class BackPack {

	public static void main(String[] args) {
		int[] capacities = new int[]{2,3,5,7};
		int[] values = new int[]{1,5,2,4};
		int result = new BackPack().backPack(10, capacities, values);
		System.out.println(result);
	}
	public int backPack(int totalCapacity, int[] capacities, int[] values) {
		int length = values.length;
		return maxPack(capacities, values, length, totalCapacity);
	}

	private int maxPack(int[] capacities, int[] values, int length, int totalCapacity) {
		int[][] pack = new int[length + 1][totalCapacity + 1];
		for (int i = 0; i <= length; i++) {
			pack[i][0] = 0;
		}
		for (int i = 1; i <= totalCapacity; i++) {
			pack[0][i] = 0;
		}
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= totalCapacity; j++) {
				int r1 = pack[i - 1][j];
				if (j < capacities[i -1]) {
					pack[i][j] = r1;
				}
				else {
					int r2 = values[i -1] + pack[i -1][j - capacities[i - 1]];
					pack[i][j] = Math.max(r1, r2);
				}
			}
		}
		return pack[length][totalCapacity];
	}
}
