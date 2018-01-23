package com.leetcode.mytest;

public class GuessNumberHigherOrLowerII {
	public static void main(String[] args) {
		GuessNumberHigherOrLowerII gn = new GuessNumberHigherOrLowerII();
		System.out.println(gn.getMoneyAmount(6));
	}
    public int getMoneyAmount(int n) {
        if (n == 1) {
        	return 0;
        }
        int[][] r = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            r[i][i] = 0;
        }
        for(int len = 2; len <= n; len++) {
            for(int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                int min = Math.min(i + r[i + 1][j], j + r[i][j - 1]);
                for(int k = i + 1; k < j; k++) {
                    int tmp = k + Math.max(r[i][k - 1], r[k+1][j]);
                    if (tmp < min) {
                        min = tmp;
                    }
                }
                r[i][j] = min;
            }
        }
        return r[1][n];
    }
}
