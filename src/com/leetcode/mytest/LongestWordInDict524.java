package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestWordInDict524 {
	public static void main(String[] args) {
		LongestWordInDict524 lw = new LongestWordInDict524();
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		d.add("applea");
		System.out.println(lw.findLongestWord(s, d));
	}

	public String findLongestWord(String s, List<String> d) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		int cur = 0;
		String result = "";
		Collections.sort(d);
		for (String str : d) {
			if (cur > 0 && str.length() < cur) {
				continue;
			}
			else {
				if (isSubSequence(str, s) && str.length() > cur) {
					cur = str.length();
					result = str;
				}
			}
		}
		return result;
	}

	private boolean isSubSequence(String str, String s) {
		if (str.length() > s.length()) {
			return false;
		}
		int n = s.length();
		int m = str.length();
		int i = 0, j = 0;

		while (i < m && j < n) {
			char c = str.charAt(i);
			while (j < n && s.charAt(j) != c) {
				j++;
			}
			if (j < n && s.charAt(j) == c) {
				i++;
				j++;
			}
		}
		return i == m;
	}
}
