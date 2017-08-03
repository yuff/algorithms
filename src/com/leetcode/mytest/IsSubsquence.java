package com.leetcode.mytest;

public class IsSubsquence {
	public static void main(String[] args) {
		IsSubsquence is = new IsSubsquence();
		System.out.println(is.isSubsequence("abc", "ahbgdc"));
		System.out.println(is.isSubsequence("leeeetcode","yyyylyyeyyyyeyyytyyyycyyyoyyyydyyyyyeyyyyyyy"));
	}

	public boolean isSubsequence(String s, String t) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		if (t == null || t.isEmpty()) {
			return false;
		}
		int m = t.length();
		int n = s.length();
		int init = 0;
		int len = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			for (int j = init; j < m; j++) {
				if (t.charAt(j) == c) {
					init = j +  1;
					len++;
					break;
				}
			}
		}
		return len == n;
	}
}
