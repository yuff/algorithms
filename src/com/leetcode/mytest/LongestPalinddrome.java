package com.leetcode.mytest;

public class LongestPalinddrome {
	public static void main(String[] args) {
		String s = "ababd";
		System.out.println(new LongestPalinddrome().longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int currentLongest = 0;
		char[] clist = s.toCharArray();
		int longestStart = -1;
		int length = clist.length;
		for (int i = 0; i < length; i++) {
			int[] offsets = longestPalindrome(clist, i);
			int len = offsets[1] - offsets[0] + 1;
			if (len > currentLongest) {
				currentLongest = len;
				longestStart = offsets[0];
			}
		}
		return new String(clist, longestStart, currentLongest);
	}

	private int[] longestPalindrome(char[] clist, int index) {
		if (index == 0) {
			return new int[] {0, 0};
		}
		else {
			int start, end;
			start = end = index;
			int length = clist.length;
			while (start >= 0) {
				if (start > 0 && clist[start - 1] == clist[index]) {
					start = start - 1;
				} else {
					break;
				}
			}
			while (end < length) {
				if (length < length - 1  && clist[length - 1] == clist[index]) {
					end = end + 1;
				} else {
					break;
				}
			}
			while (start >= 0 && end < length) {
				if (clist[start] != clist[end]) {
					break;
				}
				start--;
				end++;
			}
			start = start + 1;
			end = end - 1;
			return new int[] {start, end};
		}
	}
}
