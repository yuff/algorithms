package com.leetcode.mytest;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(new String[]{"abc", "abcde","aaaa"}));
	}
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

	private String longestCommonPrefix(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		}
		int mid = (start + end) >> 1;
		String s1 = longestCommonPrefix(strs, start, mid);
		String s2 = longestCommonPrefix(strs, mid + 1, end);
		int len1 = s1.length(), len2 = s2.length(), i = 0;
		while (i < len1 && i < len2 && s1.charAt(i) == s2.charAt(i)) {
			i++;
		}
		return s1.substring(0, i);
	}

}
