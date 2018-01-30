package com.leetcode.newround;

public class OutOfBoundaryPaths {
	public static void main(String[] args) {
		OutOfBoundaryPaths ob = new OutOfBoundaryPaths();
		System.out.println(ob.findPaths(2, 2, 2, 0, 0));
	}
    public int findPaths(int m, int n, int N, int r, int c) {
        if (N == 0) {
            return 0;
        }
        int[][][] paths = new int[m][n][N + 1];
        for(int i = 0; i < m; i++) {
        	paths[i][0][1] += 1;
        	paths[i][n - 1][1] += 1;
        }
        for(int i = 0; i < n; i++) {
        	paths[0][i][1] += 1;
        	paths[m - 1][i][1] += 1;
        }
        for(int step = 2; step <= N; step++) {
        	for(int i = 0; i < m; i++) {
        		for(int j = 0; j < n; j++) {
        			if (i > 0) {
        				paths[i][j][step] += paths[i - 1][j][step - 1];
        			}
        			if (i < m - 1) {
        				paths[i][j][step] += paths[i + 1][j][step - 1];
        			}
        			if (j > 0) {
        				paths[i][j][step] += paths[i][j - 1][step - 1];
        			}
        			if (j < n - 1) {
        				paths[i][j][step] += paths[i][j + 1][step - 1];
        			}
        		}
        	}
        }
        int result = 0;
        for(int i = 1; i <= N; i++) {
        	result += paths[r][c][i];
        }
        return result;
    }
}
