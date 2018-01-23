package com.leetcode.mytest;

import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aabcc"));
	}
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
        	return new ArrayList<>();
        }
        return new ArrayList<>(partition(s, s.length()));
    }

	private Set<List<String>> partition(String s, int length) {
		char[] arr = s.toCharArray();
		Set<List<String>> result = new HashSet<>();
		String s1 = new String(arr, 0, length);
		if (!s1.isEmpty() && isPalindrome(s1)) {
			List<String> r = new ArrayList<>();
			r.add(s1);
			result.add(r);
		}
		for(int len = 1; len <= length; len++) {
			String p = new String(arr, length - len, len);
			if (isPalindrome(p)) {
				Set<List<String>> tmp = partition(s, length - len);
				for(List<String> list: tmp) {
					list.add(p);
					result.add(list);
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String p) {
		int start = 0, end = p.length() - 1;
		while (start < end) {
			if (p.charAt(start) == p.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
}
