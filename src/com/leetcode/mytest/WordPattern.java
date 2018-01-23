package com.leetcode.mytest;

import java.util.*;

public class WordPattern {
	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
	}
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		String[] strs = str.split(" ");
		if (strs.length != pattern.length()) {
			return false;
		}
		int n = pattern.length();
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> map1 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = pattern.charAt(i);
			if (map.get(c) == null && map1.get(strs[i]) == null) {
				map.put(c, strs[i]);
				map1.put(strs[i], c);
			}
			else if (map.get(c) != null && map1.get(strs[i]) != null) {
				String s = map.get(c);
				char t = map1.get(strs[i]);
				if (!s.equals(strs[i]) || t != c) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
