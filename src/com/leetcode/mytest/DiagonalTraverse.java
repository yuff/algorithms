package com.leetcode.mytest;

public class DiagonalTraverse {
	public static void main(String[] args) {
		DiagonalTraverse dt = new DiagonalTraverse();
		int[][] matrix = new int[2][3];
		matrix[0] = new int[] {1, 2, 3};
		matrix[1] = new int[] {4, 5, 6};
		// matrix[2] = new int[] {7, 8, 9};
		// matrix[3] = new int[] {10, 11, 12};
		int[] result = dt.findDiagonalOrder(matrix);
		for (int i : result) {
			System.out.print(i);
			System.out.print(",");
		}
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new int[0];
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean isAsc = true;
		int size = m * n;
		int[] result = new int[size];
		int index = 0;
		int i = 0, j = 0;
		while (index < size) {
			result[index++] = matrix[i][j];
			if (isAsc) {
				if (i == 0 && j != n - 1) {
					j = j + 1;
					isAsc = !isAsc;
				}
				else if (j == n - 1) {
					isAsc = !isAsc;
					i = i + 1;
				}
				else {
					i = i - 1;
					j = j + 1;
				}
			}
			else {
				if (j == 0 && i != m - 1) {
					isAsc = !isAsc;
					i = i + 1;
				}
				else if (i == m - 1) {
					j = j + 1;
					isAsc = !isAsc;
				}
				else {
					i = i + 1;
					j = j - 1;
				}
			}

		}
		return result;
	}
}
