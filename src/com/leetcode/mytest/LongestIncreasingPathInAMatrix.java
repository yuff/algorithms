package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix li = new LongestIncreasingPathInAMatrix();
		int[][] matrix = new int[3][3];
		matrix[0] = new int[] {9, 9, 4};
		matrix[1] = new int[] {6, 6, 8};
		matrix[2] = new int[] {2, 1, 1};
		System.out.println(li.longestIncreasingPath(matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length, result = 0;
		int[][] max = new int[m][n];
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int key = matrix[i][j];
				if (map.get(key) == null) {
					map.put(key, new ArrayList<int[]>());
				}
				map.get(key).add(new int[] {i, j});
			}
		}
		List<Map.Entry<Integer, List<int[]>>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, List<int[]>>>() {
			@Override
			public int compare(Map.Entry<Integer, List<int[]>> o1, Map.Entry<Integer, List<int[]>> o2) {
				return o1.getKey() - o2.getKey();
			}
		});
		for (Map.Entry<Integer, List<int[]>> entry : list) {
			List<int[]> eList = entry.getValue();
			for (int[] p : eList) {
				int v = setValue(p, max, matrix);
				if (v > result) {
					result = v;
				}
			}
		}
		return result;
	}

	private int setValue(int[] p, int[][] max, int[][] matrix) {
		int result = 0, i = p[0], j = p[1], m = matrix.length, n = matrix[0].length, value = matrix[i][j];
		if (i > 0 && value > matrix[i - 1][j]) {
			result = Math.max(max[i - 1][j], result);
		}
		if (i < m - 1 && value > matrix[i + 1][j]) {
			result = Math.max(max[i + 1][j], result);
		}
		if (j > 0 && value > matrix[i][j - 1]) {
			result = Math.max(max[i][j - 1], result);
		}
		if (j < n - 1 && value > matrix[i][j + 1]) {
			result = Math.max(max[i][j + 1], result);
		}
		max[i][j] = result + 1;
		return max[i][j];
	}
}
