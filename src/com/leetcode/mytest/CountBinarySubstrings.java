package com.leetcode.mytest;

public class CountBinarySubstrings {
	public static void main(String[] args) {
		CountBinarySubstrings cb = new CountBinarySubstrings();
		System.out.println(cb.countBinarySubstrings("10101"));
		System.out.println(cb.countBinarySubstrings("00110011"));
		System.out.println(cb.countBinarySubstrings("111000"));
	}

	public int countBinarySubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count = 0, n = s.length();
		int[] counts = new int[2];
		char pre = s.charAt(0);
		counts[pre - '0'] = 1;
		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);
			if (c == pre) {
				counts[pre - '0'] += 1;
			}
			else {
				count += Math.min(counts[0], counts[1]);
				counts[c - '0'] = 1;
				pre = c;
			}
		}
		count += Math.min(counts[0], counts[1]);
		return count;
	}
}
