package com.leetcode.mytest;

public class SearchA2DMatrix {
	public static void main(String[] args) {
		SearchA2DMatrix sa = new SearchA2DMatrix();
		int[][] matrix = new int[5][5];
		matrix[0] = new int[] {1, 2, 3, 4, 5};
		matrix[1] = new int[] {6, 7, 8, 9, 10};
		matrix[2] = new int[] {11, 12, 13, 14, 15};
		matrix[3] = new int[] {16, 17, 18, 19, 20};
		 matrix[4] = new int[] {31, 32, 33, 34, 35};
		System.out.println(sa.searchMatrix(matrix, 35));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length, n = matrix[0].length, left = 0, right = m * n - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int r = mid / n, c = mid % n;
			if (matrix[r][c] == target) {
				return true;
			}
			else if (matrix[r][c] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return false;
	}
}
