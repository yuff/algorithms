package com.leetcode.mytest;

import java.util.*;

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		PacificAtlanticWaterFlow pa = new PacificAtlanticWaterFlow();
		int[][] matrix = new int[5][5];
		matrix[0] = new int[] {1, 2, 2, 3, 5};
		matrix[1] = new int[] {3, 2, 3, 4, 4};
		matrix[2] = new int[] {2, 4, 5, 3, 1};
		matrix[3] = new int[] {6, 7, 1, 4, 5};
		matrix[4] = new int[] {5, 1, 1, 2, 4};
		// List<int[]> result = pa.pacificAtlantic(matrix);
		// for (int[] r : result) {
		// System.out.print("[" + r[0] + "," + r[1] + "],");
		// }

		int[][] matrix1 = new int[20][15];
		matrix1[0] = new int[] {11, 3, 2, 4, 14, 6, 13, 18, 1, 4, 12, 2, 4, 1, 16};
		matrix1[1] = new int[] {5, 11, 18, 0, 15, 14, 6, 17, 2, 17, 19, 15, 12, 3, 14};
		matrix1[2] = new int[] {10, 2, 5, 13, 11, 11, 13, 19, 11, 17, 14, 18, 14, 3, 11};
		matrix1[3] = new int[] {14, 2, 10, 7, 5, 11, 6, 11, 15, 11, 6, 11, 12, 3, 11};
		matrix1[4] = new int[] {13, 1, 16, 15, 8, 2, 16, 10, 9, 9, 10, 14, 7, 15, 13};
		matrix1[5] = new int[] {17, 12, 4, 17, 16, 5, 0, 4, 10, 15, 15, 15, 14, 5, 18};
		matrix1[6] = new int[] {9, 13, 18, 4, 14, 6, 7, 8, 5, 5, 6, 16, 13, 7, 2};
		matrix1[7] = new int[] {19, 9, 16, 19, 16, 6, 1, 11, 7, 2, 12, 10, 9, 18, 19};
		matrix1[8] = new int[] {19, 5, 19, 10, 7, 18, 6, 10, 7, 12, 14, 8, 4, 11, 16};
		matrix1[9] = new int[] {13, 3, 18, 9, 16, 12, 1, 0, 1, 14, 2, 6, 1, 16, 6};
		matrix1[10] = new int[] {14, 1, 12, 16, 7, 15, 9, 19, 14, 4, 16, 6, 11, 15, 7};
		matrix1[11] = new int[] {6, 15, 19, 13, 3, 2, 13, 7, 19, 11, 13, 16, 0, 16, 16};
		matrix1[12] = new int[] {1, 5, 9, 7, 12, 9, 2, 18, 6, 12, 1, 8, 1, 10, 19};
		matrix1[13] = new int[] {10, 11, 10, 11, 3, 5, 12, 0, 0, 8, 15, 7, 5, 13, 19};
		matrix1[14] = new int[] {8, 1, 17, 18, 3, 6, 8, 15, 0, 9, 8, 8, 12, 5, 18};
		matrix1[15] = new int[] {8, 3, 6, 12, 18, 15, 10, 10, 12, 19, 16, 7, 17, 17, 1};
		matrix1[16] = new int[] {12, 13, 6, 4, 12, 18, 18, 9, 4, 9, 13, 11, 5, 3, 14};
		matrix1[17] = new int[] {8, 4, 12, 11, 2, 2, 10, 3, 11, 17, 14, 2, 17, 4, 7};
		matrix1[18] = new int[] {8, 0, 14, 0, 13, 17, 11, 0, 16, 13, 15, 17, 4, 8, 3};
		matrix1[19] = new int[] {18, 15, 8, 11, 18, 3, 10, 18, 3, 3, 15, 9, 11, 15, 15};
		List<int[]> result1 = pa.pacificAtlantic(matrix1);
		for (int[] r : result1) {
			System.out.print("[" + r[0] + "," + r[1] + "],");
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}
		List<int[]> result = new ArrayList<>();
		int m = matrix.length, n = matrix[0].length;
		boolean[][] up = new boolean[m][n], left = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					left[i][j] = true;
					up[i][j] = true;
				}
				else if (i == 0) {
					up[i][j] = true;
					left[i][j] = matrix[i][j] >= matrix[i][j - 1] && (left[i][j - 1] || up[i][j - 1]);
				}
				else if (j == 0) {
					left[i][j] = true;
					up[i][j] = matrix[i][j] >= matrix[i - 1][j] && (up[i - 1][j] || left[i - 1][j]);
				}
				else {
					left[i][j] = matrix[i][j] >= matrix[i][j - 1] && (left[i][j - 1] || up[i][j - 1]);
					up[i][j] = matrix[i][j] >= matrix[i - 1][j] && (up[i - 1][j] || left[i - 1][j]);
				}
			}
		}
		boolean[][] right = new boolean[m][n], down = new boolean[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (j == n - 1 && i == m - 1) {
					right[i][j] = true;
					down[i][j] = true;
				}
				else if (i == m - 1) {
					down[i][j] = true;
					right[i][j] = (right[i][j + 1] || down[i][j + 1]) && matrix[i][j] >= matrix[i][j + 1];
				}
				else if (j == n - 1) {
					right[i][j] = true;
					down[i][j] = (down[i + 1][j] || right[i + 1][j]) && matrix[i][j] >= matrix[i + 1][j];
				}
				else {
					right[i][j] = (right[i][j + 1] || down[i][j + 1]) && matrix[i][j] >= matrix[i][j + 1];
					down[i][j] = (down[i + 1][j] || right[i + 1][j]) && matrix[i][j] >= matrix[i + 1][j];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean add = false;
				if ((up[i][j] || left[i][j]) && (right[i][j] || down[i][j])) {
					add = true;
				}
				else if (right[i][j] || down[i][j]) {
					boolean canPacific = false;
					if (right[i][j]) {
						int k = j + 1;
						while (k < n) {
							if (up[i][k]) {
								canPacific = true;
								break;
							}
							k++;
						}
					}
					if (down[i][j] && !canPacific) {
						int k = i + 1;
						while (k < m) {
							if (left[k][j]) {
								canPacific = true;
								break;
							}
							k++;
						}
					}
					if (canPacific) {
						add = true;
					}
				}
				else if (up[i][j] || left[i][j]) {
					boolean canAtlantic = false;
					if (up[i][j]) {
						int k = i - 1;
						while (k >= 0) {
							if (right[k][j]) {
								canAtlantic = true;
								break;
							}
							k--;
						}
					}
					if (left[i][j] && !canAtlantic) {
						int k = j - 1;
						while (k >= 0) {
							if (down[i][k]) {
								canAtlantic = true;
								break;
							}
							k--;
						}
					}
					if (canAtlantic) {
						add = true;
					}
				}

				if (add) {
					int[] t = new int[2];
					t[0] = i;
					t[1] = j;
					result.add(t);
				}
			}
		}
		return result;
	}
}
