package com.leetcode.mytest;

public class KthSmallestElementInASortedMatrix {
	public static void main(String[] args) {
		KthSmallestElementInASortedMatrix ks = new KthSmallestElementInASortedMatrix();
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] {1, 5, 9, 14};
		matrix[1] = new int[] {10, 11, 13, 15};
		matrix[2] = new int[] {12, 15, 19, 22};
		matrix[3] = new int[] {13, 16, 20, 23};
		System.out.println(ks.kthSmallest(matrix, 16));
	}

	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0) {
			throw new RuntimeException("error input");
		}
		int n = matrix.length;
		if (k == n * n) {
			return matrix[n - 1][n - 1];
		}
		int[] index = new int[n];
		index[0] = 1;
		int[] result = new int[k];
		result[0] = matrix[0][0];
		for (int i = 1; i < k; i++) {
			int tmp = Integer.MAX_VALUE;
			int smallJ = -1;
			int smallId = -1;
			for (int j = 0; j < n; j++) {
				int id = index[j];
				if (id < n && matrix[j][id] < tmp) {
					tmp = matrix[j][id];
					smallJ = j;
					smallId = id + 1;
				}
			}
			result[i] = tmp;
			index[smallJ] = smallId;
		}
		return result[k - 1];
	}
}
