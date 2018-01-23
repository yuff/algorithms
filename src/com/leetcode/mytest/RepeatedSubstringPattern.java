package com.leetcode.mytest;

public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		RepeatedSubstringPattern ps = new RepeatedSubstringPattern();
		// System.out.println(ps.repeatedSubstringPattern("abcabcabc"));
		System.out.println(ps.repeatedSubstringPattern("bb"));
	}

	public boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		int n = s.length();
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				int len = n / i;
				String t = s.substring(0, len);
				int j = 1;
				while (j < i) {
					if (t.equals(s.substring(j * len, (j + 1) * len))) {
						j++;
					}
					else {
						break;
					}
				}
				if (j == i) {
					return true;
				}
			}
		}
		return false;
	}
}
