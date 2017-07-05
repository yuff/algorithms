package com.leetcode.mytest;

import java.util.regex.Pattern;

public class DetectCapital {
	public static void main(String[] args) {

		String reg = "^[a-z]*[a-z]$|^[A-Z][a-z]*[a-z]$|^[A-Z]*[A-Z]$";
		Pattern p = Pattern.compile(reg);
		String s = "Ga";
		System.out.println(s.matches(reg));
	}

	public boolean detectCapitalUse(String word) {
		int length = word.length();
		if (length < 2) {
			return true;
		}
		char[] charArray = word.toCharArray();
		char c1 = charArray[0];
		if (c1 >= 65 && c1 <= 90) {
			char c2 = charArray[1];
			if (c2 >= 65 && c2 <= 90) {
				for (int i = 2; i < length; i++) {
					if (!(charArray[i] >= 65 && charArray[i] <= 90)) {
						return false;
					}
				}
			}
			else if (c2 >= 97 && c2 <= 122) {
				for (int i = 2; i < length; i++) {
					if (!(charArray[i] >= 97 && charArray[i] <= 122)) {
						return false;
					}
				}
			}

		} else if (c1 >= 97 && c1 <= 122) {
			for (int i = 1; i < length; i++) {
				if (!(charArray[i] >= 97 && charArray[i] <= 122)) {
					return false;
				}
			}
		}
		return true;
	}
}
