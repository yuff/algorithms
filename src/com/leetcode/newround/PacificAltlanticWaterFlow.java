package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class PacificAltlanticWaterFlow {
	public static void main(String[] args) {
		PacificAltlanticWaterFlow pa = new PacificAltlanticWaterFlow();
		int[][] matrix = new int[16][15];
		matrix[0] = new int[] {8, 13, 11, 18, 14, 16, 16, 4, 4, 8, 10, 11, 1, 19, 7};
		matrix[1] = new int[] {2, 9, 15, 16, 14, 5, 8, 15, 9, 5, 14, 6, 10, 15, 5};
		matrix[2] = new int[] {15, 16, 17, 10, 3, 6, 3, 4, 2, 17, 0, 12, 4, 1, 3};
		matrix[3] = new int[] {13, 6, 13, 15, 15, 16, 4, 10, 7, 4, 19, 19, 4, 9, 13};
		matrix[4] = new int[] {7, 1, 9, 14, 9, 11, 5, 4, 15, 19, 6, 0, 0, 13, 5};
		matrix[5] = new int[] {9, 9, 15, 12, 15, 5, 1, 1, 18, 1, 2, 16, 15, 18, 9};
		matrix[6] = new int[] {13, 0, 4, 18, 12, 0, 11, 0, 1, 15, 1, 15, 4, 2, 0};
		matrix[7] = new int[] {11, 13, 12, 16, 9, 18, 6, 8, 18, 1, 5, 12, 17, 13, 5};
		matrix[8] = new int[] {7, 17, 2, 5, 0, 17, 9, 18, 4, 13, 6, 13, 7, 2, 1};
		matrix[9] = new int[] {2, 3, 9, 0, 19, 6, 6, 15, 14, 4, 8, 1, 19, 5, 9};
		matrix[10] = new int[] {3, 10, 5, 11, 7, 14, 1, 5, 3, 19, 12, 5, 2, 13, 16};
		matrix[11] = new int[] {0, 8, 10, 18, 17, 5, 5, 8, 2, 11, 5, 16, 4, 9, 14};
		matrix[12] = new int[] {15, 9, 16, 18, 9, 5, 2, 5, 13, 3, 10, 19, 9, 14, 3};
		matrix[13] = new int[] {12, 11, 16, 1, 10, 12, 6, 18, 6, 6, 18, 10, 9, 5, 2};
		matrix[14] = new int[] {17, 9, 6, 6, 14, 9, 2, 2, 13, 13, 15, 17, 15, 3, 14};
		matrix[15] = new int[] {18, 14, 12, 6, 18, 16, 4, 10, 19, 5, 6, 8, 9, 1, 6};
		List<int[]> result = pa.pacificAtlantic(matrix);
		for (int[] r : result) {
			CommonUtil.print(r);
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] altantic = new boolean[m][n];
		List<int[]> result = new ArrayList<>();
		for(int i = 0; i < m; i++){
            pacific[i][0] = true;
            update(pacific, i, 0, matrix);
            altantic[i][n-1] = true;
            update(altantic, i, n-1, matrix);
        }
        
        for(int j = 0; j < n; j++){
            pacific[0][j] = true;
            update(pacific, 0, j, matrix);
            altantic[m-1][j] = true;
            update(altantic, m-1, j, matrix);
        }  

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (altantic[i][j] && pacific[i][j]) {
					result.add(new int[] {i, j});
				}
			}
		}
		return result;
	}

	private void update(boolean[][] pa, int i, int j, int[][] matrix) {
		if (i > 0) {
			if (matrix[i - 1][j] >= matrix[i][j]) {
				process(pa, i - 1, j, matrix);
			}
		}
		if (i < matrix.length - 1) {
			if (matrix[i + 1][j] >= matrix[i][j]) {
				process(pa, i + 1, j, matrix);
			}
		}

		if (j > 0) {
			if (matrix[i][j - 1] >= matrix[i][j]) {
				process(pa, i , j - 1, matrix);
			}
		}
		if (j < matrix[0].length - 1) {
			if (matrix[i][j + 1] >= matrix[i][j]) {
				process(pa, i , j + 1, matrix);
			}
		}
	}

	public void process(boolean[][] pa, int i, int j, int[][] matrix) {
		if (!pa[i][j]) {
			pa[i][j] = true;
			update(pa, i, j, matrix);
		}
	}
}
