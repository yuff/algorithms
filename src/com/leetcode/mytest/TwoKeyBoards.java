package com.leetcode.mytest;

public class TwoKeyBoards {
	public static void main(String[] args) {
		TwoKeyBoards tkb = new TwoKeyBoards();
		System.out.println(tkb.minSteps(9));
		
	}
    public int minSteps(int n) {
        if(n < 2) {
            return 0;
        }
        int[] min = new int[n + 1];
        min[1] = 0;
        min[2] = 2;
        for(int i = 2; i <= n; i++) {
            int m = i;
            for(int j = (int) Math.sqrt(i); j >1; j--) {
                if (i % j == 0) {
                    int d = i / j;
                    int tmp = Math.min(min[j] + d, min[d] + j);
                    if (tmp < m) {
                        m = tmp;
                    }
                }
            }
            min[i] = m;
        }
        return min[n];
    }
}
