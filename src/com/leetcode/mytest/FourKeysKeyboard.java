package com.leetcode.mytest;

public class FourKeysKeyboard {
	public static void main(String[] args) {
		FourKeysKeyboard fk = new FourKeysKeyboard();
		System.out.println(fk.maxA(3));
		System.out.println(fk.maxA(11));
	}
	public int maxA(int N) {
		int[] maxs = new int[N + 1];
		for(int i = 0; i < 4; i++) {
			maxs[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			int m  = i;
			 for(int j = 1; j < i-2; j++) {
				 int tmp = maxs[j] * (i - j - 1);
				 if (tmp > m) {
					 m = tmp;
				 }
			 }
			 maxs[i] = m;
		}
		return maxs[N];
	}
}
