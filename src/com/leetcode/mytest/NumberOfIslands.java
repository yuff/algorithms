package com.leetcode.mytest;

public class NumberOfIslands {
	public static void main(String[] args) {
		NumberOfIslands no = new NumberOfIslands();
		char[][] grid = new char[3][5];
		grid[0] = new char[] {'1', '0', '1', '1', '1'};
		grid[1] = new char[] {'1', '0', '1', '0', '1'};
		grid[2] = new char[] {'1', '1', '1', '0', '1'};
//		grid[3] = new char[] {'0', '0', '0', '1', '1'};
		char[][] g = new char[1][7];
		g[0] = new char[] {'1', '0', '1', '1', '0', '1', '1'};
		System.out.println(no.numIslands(g));
		System.out.println(no.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length, r = 0;
		boolean[][] marked = new boolean[m][n];
		boolean first = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != '1') {
					continue;
				}
				else {
					if (!first) {
						first = true;
						r++;
						markGrid(grid, marked, i, j);
					}
					else {
						boolean left = false, right = false, up = false, down = false;
						if (i > 0) {
							up = marked[i - 1][j];
						}
						if (i < m - 1) {
							down = marked[i + 1][j];
						}
						if (j > 0) {
							left = marked[i][j - 1];
						}
						if (j < n - 1) {
							right = marked[i][j + 1];
						}
						if (!(left || right || up || down)) {
							r++;
						}
						markGrid(grid, marked, i, j);
					}
				}
			}
		}
		return r;
	}

	private void markGrid(char[][] grid, boolean[][] marked, int i, int j) {
		int m = grid.length, n = grid[0].length;
		marked[i][j] = true;
		if (i > 0) {
			if (grid[i - 1][j] == '1' && !marked[i - 1][j]) {
				markGrid(grid, marked, i - 1, j);
			}
		}
		if (i < m - 1) {
			if (grid[i + 1][j] == '1' && !marked[i + 1][j]) {
				markGrid(grid, marked, i + 1, j);
			}
		}
		if (j > 0) {
			if (grid[i][j - 1] == '1' && !marked[i][j - 1]) {
				markGrid(grid, marked, i, j - 1);
			}
		}
		if (j < n - 1) {
			if (grid[i][j + 1] == '1' && ! marked[i][j + 1]) {
				markGrid(grid, marked, i, j + 1);
			}
		}
	}
}
