package com.leetcode.mytest;

public class OnesAndZeros {
	public static void main(String[] args) {
		OnesAndZeros oaz = new OnesAndZeros();
		System.out.println(oaz.findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
	}

	public int findMaxForm(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) {
			return 0;
		}
		int len = strs.length;
		int[][] forms = new int[len][2];
		generateForms(strs, forms);
		int[][][] r = new int[m + 1][n + 1][len];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i >= forms[0][0] && j >= forms[0][1]) {
					r[i][j][0] = 1;
				}
			}
		}
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 1; k < len; k++) {
					int a = 0, b = 0;
					if (forms[k][0] <= i && forms[k][1] <= j) {
						a = 1 + r[i - forms[k][0]][j - forms[k][1]][k - 1];
					}
					b = r[i][j][k - 1];
					r[i][j][k] = Math.max(a, b);
				}
			}
		}
		return r[m][n][len - 1];
	}

	private void generateForms(String[] strs, int[][] forms) {
		int n = strs.length;
		for (int i = 0; i < n; i++) {
			forms[i] = generateForm(strs[i]);
		}
	}

	private int[] generateForm(String str) {
		int[] result = new int[2];
		int len = str.length();
		int zero = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == '0') {
				zero++;
			}
		}
		result[0] = zero;
		result[1] = len - zero;
		return result;
	}
}
