package com.leetcode.newround;

public class RepeatedStringMatch {
	public static void main(String[] args) {
		RepeatedStringMatch rs = new RepeatedStringMatch();
		String a = "abcdcdabcdababcd";
		String b = "cdabcdab";
		System.out.println(rs.repeatedStringMatch(a , b));
	}
	public int repeatedStringMatch(String A, String B) {
		if (A == null || A.length() == 0) {
			return -1;
		}
		if (B == null || B.length() == 0) {
			return 0;
		}
		int[] prefix = preparePrefix(B);
		int m = A.length(), n = B.length(), q = 0;
		for(int i = 0; i < m; i++) {
			char a = A.charAt(i);
			while (q > 0 && a != B.charAt(q)) {
				q = prefix[q - 1];
			}
			if (a == B.charAt(q)) {
				q++;
			}
			if (q == n) {
				return 1;
			}
		}
		int i = 0, count = 1;
		while (q < n) {
			if (A.charAt(i) == B.charAt(q)) {
				i++;
				q++;
				if (i == m) {
					count++;
					i = 0;
				}
			} else {
				return -1;
			}
		}
		return count + (i > 0? 1: 0);
	}

	private int[] preparePrefix(String s) {
		int n = s.length();
		int[] prefix = new int[n];
		prefix[0] = 0;
		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);
			int k = prefix[i - 1];
			while (k > 0 && s.charAt(k) != c) {
				k = prefix[k - 1];
			}
			prefix[i] = s.charAt(k) == c ? k + 1 : k;
		}
		return prefix;
	}
}
