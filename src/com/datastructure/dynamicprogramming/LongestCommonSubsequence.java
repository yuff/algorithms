package com.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "abcabcaa";
		String s2 = "acbacba";
		List<String> result = lcs.allLongestCommonSubsequence(s1, s2);
		 Collections.sort(result);
		System.out.println(result);
		for (String s : result) {
			System.out.println(s);
		}
	}

	public List<String> allLongestCommonSubsequence(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
			return new ArrayList<String>();
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int len1 = s1.length();
		int len2 = s2.length();
		boolean[][] b = new boolean[len1][len2];
		int[][] c = new int[len1][len2];
		findLongestCommonSequence(str1, str2, b, c);
		return printAllLcs(str1, str2, b, c);
	}

	public String longestCommonSubsequence(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
			return "";
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int len1 = s1.length();
		int len2 = s2.length();
		boolean[][] b = new boolean[len1][len2];
		int[][] c = new int[len1][len2];
		findLongestCommonSequence(str1, str2, b, c);
		return generatelcs(str1, str2, b, c);
	}

	private String generatelcs(char[] str1, char[] str2, boolean[][] b, int[][] c) {
		int len1 = str1.length;
		int len2 = str2.length;
		int length = c[len1 - 1][len2 - 1];
		int curLen = length;
		int lastIndex = len2 - 1;
		char[] result = new char[length];
		while (curLen > 0) {
			for (int i = len1 - 1; i >= 0; i--) {
				for (int j = lastIndex; j >= 0; j--) {
					if (b[i][j] && c[i][j] == curLen) {
						result[curLen - 1] = str1[i];
						lastIndex = j;
						curLen--;
						break;
					}
				}
			}
		}
		return new String(result);
	}

	private List<String> printAllLcs(char[] str1, char[] str2, boolean[][] b, int[][] c) {
		List<String> result = new ArrayList<>();
		int len1 = str1.length;
		int len2 = str2.length;
		int longestLen = c[len1 - 1][len2 - 1];
		char[] tmp = new char[longestLen];
		printLcs(result, str1, str2, b, c, tmp, longestLen, len1, len2);
		return result;
	}

	private void printLcs(List<String> result, char[] str1, char[] str2, boolean[][] b, int[][] c,
	                      char[] tmp, int length, int iLen, int jLen) {
		if (length == 0) {
			String s = new String(tmp);
			if (!result.contains(s)) {
				result.add(s);
			}
			return;
		}
		for (int i = iLen - 1; i >= 0; i--) {
			for (int j = jLen - 1; j >= 0; j--) {
				if (b[i][j] && c[i][j] == length) {
					tmp[length - 1] = str1[i];
					printLcs(result, str1, str2, b, c, tmp, length - 1, i, j);
				}
			}
		}
	}

	private void findLongestCommonSequence(char[] str1, char[] str2, boolean[][] b, int[][] c) {
		int len1 = str1.length;
		int len2 = str2.length;
		if (b == null || c == null || b.length != len1 || c.length != len1 || b[0].length != len2 ||
		    c[0].length != len2) {
			throw new RuntimeException("error");
		}
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (str1[i] == str2[j]) {
					b[i][j] = true;
					if (i == 0 || j == 0) {
						c[i][j] = 1;
					}
					else {
						c[i][j] = c[i - 1][j - 1] + 1;
					}
				}
				else {
					if (i == 0 && j == 0) {
						c[i][j] = 0;
					}
					else {
						int c1 = 0, c2 = 0;
						if (j > 0) {
							c1 = c[i][j - 1];
						}
						if (i > 0) {
							c2 = c[i - 1][j];
						}
						c[i][j] = Math.max(c1, c2);
					}
				}
			}
		}
	}
}
