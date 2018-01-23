package com.leetcode.newround;

public class WildcardMatching {
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("a", "aa"));
		System.out.println(wm.isMatch("c", "*?*"));
		System.out.println(wm.isMatch("c", "*?*?"));
		System.out.println(wm.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println(wm.isMatch("aa", "a"));
		System.out.println(wm.isMatch("aa", "aa"));
		System.out.println(wm.isMatch("aaa", "aa"));
		System.out.println(wm.isMatch("aa", "*"));
		System.out.println(wm.isMatch("aa", "a*"));
		System.out.println(wm.isMatch("a", "a*"));
		System.out.println(wm.isMatch("ab", "?*"));
		System.out.println(wm.isMatch("aab", "c*a*b"));
		System.out.println(wm.isMatch("abccb", "*c*"));
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		else if (s.isEmpty()) {
			return false;
		}
		else if (s.isEmpty()) {
			return p.length() == 1 && p.charAt(0) == '*';
		}
		int m = s.length(), n = p.length();
		boolean[][] match = new boolean[m][n];
		char p0 = p.charAt(0);
		for (int i = 0; i < m; i++) {
			if (p0 == '*') {
				match[i][0] = true;
			}
			else {
				match[i][0] = i == 0 && (p0 == '?' || p0 == s.charAt(i));
			}
		}
		char s0 = s.charAt(0);
		int count = p0 == '*' ? 0 : 1;
		for (int i = 1; i < n; i++) {
			char pi = p.charAt(i);
			if (s0 == pi || pi == '?') {
				match[0][i] = match[0][i - 1] && count == 0;
				count++;
			}
			else if (pi == '*') {
				match[0][i] = match[0][i - 1];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				char si = s.charAt(i), pj = p.charAt(j);
				if (si == pj || pj == '?') {
					match[i][j] = match[i - 1][j - 1];
				}
				else if (pj == '*') {
					match[i][j] = match[i - 1][j - 1] || match[i - 1][j] || match[i][j - 1];
				}
			}
		}
		return match[m - 1][n - 1];
	}
}
