package com.java8.streamtest;

import java.util.HashMap;
import java.util.Map;

public class Compare {

	public static int longestPalindrome(String s) {
		char[] cList = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : cList) {
			if (map.get(c) == null) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c) + 1);
			}
		}
		int result = 0;
		boolean extra = false;
		for (char c : map.keySet()) {
			int num = map.get(c);
			if (!extra && num % 2 != 0) {
				extra = true;
			}
			result += num >> 1;
		}
		return extra? result * 2 + 1 : result *2;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
	}
}
