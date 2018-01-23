package com.leetcode.newround;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		RegularExpressionMatching re = new RegularExpressionMatching();
		System.out.println(re.isMatch("aaa", "ab*a"));
	}

	public boolean isMatch(String s, String p) {
		if (p == null || s == null) {
			return false;
		}
		else if (s.isEmpty()) {
			return true;
		}
		else if (p.isEmpty()) {
			return false;
		}
		int m = s.length(), n = p.length();
		boolean[][] match = new boolean[m + 1][n + 1];
		match[0][0] = true;
		for (int i = 0; i < n; i++) {
			char pi = p.charAt(i);
			if (pi == '*' && match[0][i - 1]) {
				match[0][i + 1] = true;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char pj = p.charAt(j);
				char si = s.charAt(i);
				if (pj == '.' || pj == si) {
					match[i + 1][j + 1] = match[i][j];
				}
				else if (pj == '*') {
					char pj1 = p.charAt(j - 1);
					if (pj1 == si || pj1 == '.') {
						match[i + 1][j + 1] = match[i][j + 1] || match[i + 1][j] || match[i + 1][j - 1];
					}
					else {
						match[i + 1][j + 1] = match[i + 1][j - 1];
					}
				}
			}
		}
		return match[m][n];
	}
}
