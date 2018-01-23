package com.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * Problem Statement
 * 
 * You are given two Strings: A and B. You would like to align these two strings by inserting '-'
 * characters in them so that every character in A lines up with the same character in B or with a
 * '-' in B, and vice versa. Each maximal sequence of consecutive '-' characters costs x, plus an
 * additional 1 per each '-' character. For example, changing "ABC" to "A-B-C" costs x+1+x+1, while
 * changing it to "A--BC" costs x+2. Given, A, B, and x return the minimum cost to align the two
 * strings.
 * 
 * 
 * Definition
 * 
 * 
 * Class: Alignment Method: align Parameters: String, String, int Returns: int Method signature: int
 * align(String A, String B, int x) (be sure your method is public)
 * 
 * 
 * 
 * 
 * 
 * Constraints
 * 
 * - A and B each contain between 1 and 50 uppercase letters ('A'-'Z'), inclusive. - x will be
 * between 0 and 100, inclusive.
 * 
 * 
 * Examples
 * 
 * 0)
 * 
 * 
 * "ABC"
 * 
 * "ACE"
 * 
 * 1
 * 
 * 
 * Returns: 4
 * 
 * 
 * We can line things up as: ABC- A-CE
 * 
 * 
 * 
 * 
 * 1)
 * 
 * 
 * "AAABAAAABAA"
 * 
 * "AAAABAABAAA"
 * 
 * 1
 * 
 * 
 * Returns: 7
 * 
 * 
 * AAA-BAAAABAA- AAAABAA--BAAA
 * 
 * 
 * 
 * 
 * 2)
 * 
 * 
 * "AAABAAAABAA"
 * 
 * "AAAABAABAAA"
 * 
 * 10
 * 
 * 
 * Returns: 28
 * 
 * 
 * AAABAAAABAA---- AAA----ABAABAAA
 * 
 * 
 * 
 * 
 * 3)
 * 
 * 
 * "AA"
 * 
 * "B"
 * 
 * 1
 * 
 * 
 * Returns: 5
 *
 * 
 * 
 * 
 */
public class Alignment {

	public static void main(String[] args) {
		Alignment al = new Alignment();
		String a = "AAABAAAABAA";
		String b = "AAAABAABAAA";
		System.out.println(al.align(a, b, 1));
		System.out.println(al.align(a, b, 10));

		String a1 = "ABC";
		String b1 = "ACE";
		System.out.println(al.align(a1, b1, 1));

		String a2 = "AA";
		String b2 = "B";
		System.out.println(al.align(a2, b2, 1));
	}

	public int align(String a, String b, int x) {
		int m = a.length(), n = b.length();
		int[][] lcs = new int[m][n];
		boolean[][] flag = new boolean[m][n];
		findLCS(a, b, lcs, flag);
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		if (lcs[m - 1][n - 1] == 0) {
			min[0] = m + n + 2 * x;
		}
		findLCSIndexs(a, b, lcs, flag, min, x);
		return min[0];
	}

	private int calculateCost(int[][] ids, int x, int m, int n) {
		int len = ids.length;
		int c = 0;
		c += ids[0][0] != 0 ? (x + ids[0][0]) : 0;
		c += ids[0][1] != 0 ? (x + ids[0][1]) : 0;
		for (int i = 1; i < len; i++) {
			int a = ids[i][0] - ids[i - 1][0] - 1;
			int b = ids[i][1] - ids[i - 1][1] - 1;
			c += a != 0 ? (x + a) : 0;
			c += b != 0 ? (x + b) : 0;
		}
		int a = m - ids[len - 1][0] - 1;
		int b = n - ids[len - 1][1] - 1;
		c += a != 0 ? (x + a) : 0;
		c += b != 0 ? (x + b) : 0;
		return c;
	}

	private void findLCSIndexs(String a, String b, int[][] lcs, boolean[][] flag, int[] min, int x) {
		int m = a.length(), n = b.length();
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (flag[i][j]) {
					int len = lcs[i][j];
					int[][] tmp = new int[len][2];
					tmp[len - 1][0] = i;
					tmp[len - 1][1] = j;
					findLCSIndex(lcs, flag, tmp, len - 1, i - 1, j - 1, min, a.length(), b.length(), x);
				}
			}
		}
	}

	private void findLCSIndex(int[][] lcs, boolean[][] flag, int[][] tmp, int length, int aIndex,
	                          int bIndex, int[] min, int m, int n, int x) {
		if (length == 0) {
			int t = calculateCost(tmp, x, m, n);
			if (t < min[0]) {
				min[0] = t;
			}
			return;
		}
		for (int i = aIndex; i >= 0; i--) {
			for (int j = bIndex; j >= 0; j--) {
				if (lcs[i][j] == length && flag[i][j]) {
					tmp[length - 1][0] = i;
					tmp[length - 1][1] = j;
					findLCSIndex(lcs, flag, tmp, length - 1, i - 1, j - 1, min, m, n, x);
				}
			}
		}
	}

	private void findLCS(String a, String b, int[][] lcs, boolean[][] flag) {
		int m = a.length(), n = b.length();
		for (int i = 0; i < m; i++) {
			if (a.charAt(i) == b.charAt(0)) {
				lcs[i][0] = 1;
				flag[i][0] = true;
			}
			else {
				if (i > 0) {
					lcs[i][0] = lcs[i - 1][0];
				}
				flag[i][0] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			if (a.charAt(0) == b.charAt(i)) {
				lcs[0][i] = 1;
				flag[0][i] = true;
			}
			else {
				if (i > 0) {
					lcs[0][i] = lcs[0][i - 1];
				}
				flag[0][i] = false;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
					flag[i][j] = true;
				}
				else {
					flag[i][j] = false;
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
	}
}
