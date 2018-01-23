package com.leetcode.mytest;

public class ShortestPalindrome {
	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("aabba"));
		System.out.println(sp.shortestPalindrome("abcd"));
		System.out.println(sp.shortestPalindrome("aacecaaa"));
	}

	public String shortestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		String tmp = s + "#" + new StringBuilder(s).reverse().toString();
		int len = tmp.length();
		int[] table = new int[len];
		table[0] = 0;
		int k = 0;
		for (int i = 1; i < len; i++) {
			char c = tmp.charAt(i);
			while (k > 0 && tmp.charAt(k) != c) {
				k = table[k - 1];
			}
			if (tmp.charAt(k) == c) {
				k++;
			}
			table[i] = k;
		}
		return new StringBuilder(s.substring(table[len - 1])).reverse().toString() + s;
	}

	public String shortestPalindrome1(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		int n = s.length();
		int i = n - 1;
		char[] arr = s.toCharArray();
		while (i >= 0) {
			if (isPalindrome(arr, i)) {
				break;
			}
			i--;
		}
		return new StringBuilder(s.substring(i + 1)).reverse().toString() + s;
		// StringBuilder builder = new StringBuilder();
		// for (int j = n - 1; j > i; j--) {
		// builder.append(s.charAt(j));
		// }
		// builder.append(s);
		// return builder.toString();
	}

	private boolean isPalindrome(char[] s, int end) {
		int i = 0, j = end;
		while (i <= j) {
			if (s[i] == s[j]) {
				i++;
				j--;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
