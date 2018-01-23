package com.leetcode.mytest;

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("0P"));
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("race a car"));
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		int start = 0, end = s.length() - 1;
		while (start <= end) {
			while (start <= end && !isAlphanumeric(s.charAt(start))) {
				start++;
			}
			while (start <= end && !isAlphanumeric(s.charAt(end))) {
				end--;
			}
			if (start > end) {
				return true;
			}
			char cs = s.charAt(start);
			char ce = s.charAt(end);
			if (cs == ce || (isAlpha(cs) && isAlpha(ce) && Math.abs(cs - ce) == Math.abs('A' - 'a'))) {
				start++;
				end--;
			}
			else {
				return false;
			}
		}
		return true;
	}

	private boolean isAlphanumeric(char c) {
		return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

	private boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}
}
