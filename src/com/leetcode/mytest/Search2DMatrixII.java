package com.leetcode.mytest;

public class Search2DMatrixII {
	public static void main(String[] args) {
		Search2DMatrixII s = new Search2DMatrixII();
		int[][] matrix = new int[5][5];
		matrix[0] = new int[] {1, 4, 7, 11, 15};
		matrix[1] = new int[] {2, 5, 8, 12, 19};
		matrix[2] = new int[] {3, 6, 9, 16, 22};
		matrix[3] = new int[] {10, 13, 14, 17, 24};
		matrix[4] = new int[] {18, 21, 23, 26, 30};
		System.out.println(s.searchMatrix(matrix, 24));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
			return false;
		}
		int[] s = new int[2];
		int[] e = new int[2];
		e[0] = m - 1;
		e[1] = n - 1;
		findRange(matrix, s, e, target);
		for (int i = s[0]; i <= e[0]; i++) {
			for (int j = s[1]; j <= e[1]; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;

	}

	private void findRange(int[][] matrix, int[] s, int[] e, int target) {
		int[] mid = new int[2];
		if (e[0] - s[0] < 2 && e[1] - s[1] < 2) {
			return;
		}
		mid[0] = (s[0] + e[0]) >> 1;
		mid[1] = (s[1] + e[1]) >> 1;
		if (matrix[mid[0]][mid[1]] > target) {
			e = mid;
			findRange(matrix, s, mid, target);
		}
		else {
			s = mid;
			findRange(matrix, mid, e, target);
		}
	}

}
