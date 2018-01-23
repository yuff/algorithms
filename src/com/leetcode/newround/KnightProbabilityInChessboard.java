package com.leetcode.newround;

public class KnightProbabilityInChessboard {
	public static void main(String[] args) {
		KnightProbabilityInChessboard kp = new KnightProbabilityInChessboard();
		System.out.println(kp.knightProbability(8, 30, 6, 4));
	}

	public double knightProbability(int N, int K, int r, int c) {
		if (N == 0) {
			return 0;
		}
		if (K == 0) {
			return 1;
		}
		double[][][] remain = new double[N][N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				remain[i][j][0] = calRemainCount(N, i, j);
			}
		}
		for (int t = 1; t < K; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					remain[i][j][t] = calRemainCount(N, i, j, t - 1, remain);
				}
			}
		}
		return remain[r][c][K - 1];
	}


	private double calRemainCount(int n, int i, int j, int t, double[][][] remain) {
		double sum = 0;
		if (i - 2 >= 0) {
			if (j - 1 >= 0) {
				sum += remain[i - 2][j - 1][t];
			}
			if (j + 1 < n) {
				sum += remain[i - 2][j + 1][t];
			}
		}
		if (i + 2 < n) {
			if (j - 1 >= 0) {
				sum += remain[i + 2][j - 1][t];
			}
			if (j + 1 < n) {
				sum += remain[i + 2][j + 1][t];
			}
		}
		if (j - 2 >= 0) {
			if (i - 1 >= 0) {
				sum += remain[i - 1][j-2][t];
			}
			if (i + 1 < n) {
				sum += remain[i + 1][j-2][t];
			}
		}
		if (j + 2 < n) {
			if (i - 1 >= 0) {
				sum += remain[i - 1][j+2][t];
			}
			if (i + 1 < n) {
				sum += remain[i + 1][j+2][t];
			}
		}
		return sum/8.0;
	}

	public double calRemainCount(int n, int i, int j) {
		int sum = 0;
		if (i - 2 >= 0) {
			if (j - 1 >= 0) {
				sum++;
			}
			if (j + 1 < n) {
				sum++;
			}
		}
		if (i + 2 < n) {
			if (j - 1 >= 0) {
				sum++;
			}
			if (j + 1 < n) {
				sum++;
			}
		}
		if (j - 2 >= 0) {
			if (i - 1 >= 0) {
				sum++;
			}
			if (i + 1 < n) {
				sum++;
			}
		}
		if (j + 2 < n) {
			if (i - 1 >= 0) {
				sum++;
			}
			if (i + 1 < n) {
				sum++;
			}
		}
		return (double)sum/8.0;
	}
}
