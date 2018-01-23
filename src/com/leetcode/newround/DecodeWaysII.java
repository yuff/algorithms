package com.leetcode.newround;

public class DecodeWaysII {
	public static void main(String[] args) {
		DecodeWaysII dw = new DecodeWaysII();
		System.out.println(dw.numDecodings("11230*"));
		System.out.println(dw.numDecodings("**********1111111111"));
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int mod = 1000000007;
		int n = s.length();
		long[] ways = new long[n + 1];
		ways[0] = 1;
		ways[1] = s.charAt(0) == '0' ? 0 : (s.charAt(0) == '*' ? 9 : 1);
		for (int i = 2; i <= n; i++) {
			char cur = s.charAt(i - 1), pre = s.charAt(i - 2);
			switch (cur) {
				case '0':
					ways[i] = pre == '*' ? (ways[i - 2] * 2) % mod
					                     : ((pre == '1' || pre == '2') ? ways[i - 2] : 0);
					break;
				case '*':
					ways[i] = (ways[i - 1] * 9) % mod;
					if (pre == '1') {
						ways[i] += (ways[i - 2] * 9 % mod);
						ways[i] %= mod;
					}
					else if (pre == '2') {
						ways[i] += (ways[i - 2] * 6 % mod);
						ways[i] %= mod;
					}
					else if (pre == '*') {
						ways[i] += (((ways[i - 2] * 9) % mod + (ways[i - 2] * 6) % mod) % mod);
						ways[i] %= mod;
					}
					break;
				default:
					ways[i] = ways[i - 1];
					if (pre == '1') {
						ways[i] += ways[i - 2];
					}
					else if (pre == '2' && cur <= '6') {
						ways[i] += ways[i - 2];
					}
					else if (pre == '*') {
						if (cur <= '6') {
							ways[i] += (ways[i - 2] * 2 % mod);
						}
						else {
							ways[i] += (ways[i - 2] % mod);
						}
					}
					break;
			}
			ways[i] %= mod;
		}
		return (int)ways[n];
	}
}
