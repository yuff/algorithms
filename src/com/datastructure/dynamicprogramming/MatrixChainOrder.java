package com.datastructure.dynamicprogramming;

public class MatrixChainOrder {

	public static void main(String[] args) {
		int[] p = new int[] {30, 35, 15, 5, 10, 20, 25};
		MatrixChainOrder mco = new MatrixChainOrder();
		System.out.println(mco.printOptimalChain(p));
	}

	public String printOptimalChain(int[] p) {
		StringBuilder builder = new StringBuilder();
		int length = p.length - 1;
		if (length == 1) {
			builder.append("A");
			builder.append(1);
		}
		else {
			int[][] m = new int[length][length];
			int[][] s = new int[length][length];
			matrixChainOrder(p, m, s);
			builder.append(printOptimalParens(s, 0, length - 1));
		}
		return builder.toString();
	}

	private String printOptimalParens(int[][] s, int i, int j) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		if (i == j) {
			builder.append("A");
			builder.append(i + 1);
		}
		else {
			builder.append("(");
			builder.append(printOptimalParens(s, i, s[i][j]));
			builder.append(printOptimalParens(s, s[i][j] + 1, j));
			builder.append(")");
		}
		return builder.toString();
	}

	public void matrixChainOrder(int[] p, int[][] m, int[][] s) {
		int length = p.length - 1;
		if (length <= 1) {
			return;
		}
		for (int i = 0; i < length; i++) {
			m[i][i] = 0;
			s[i][i] = i;
		}
		for (int len = 2; len < length; len++) {
			for (int i = 0; i < length - len + 1; i++) {
				int j = i + len - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k + 1][j] + p[i] * p[k+1] * p[j + 1];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
}
