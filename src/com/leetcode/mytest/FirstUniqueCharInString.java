package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class FirstUniqueCharInString {
	public static void main(String[] args) {
		FirstUniqueCharInString fu = new FirstUniqueCharInString();
		String s = "abcdabcd";
		System.out.println(fu.firstUniqChar(s));
	}

	public int firstUniqChar(String s) {
		if (s == null || s.isEmpty()) {
			return -1;
		}
		List<List<Integer>> list = new ArrayList<>(26);
		for(int i = 0; i < 26; i++) {
			list.add(new ArrayList<Integer>());
		}
		int n = s.length();
		for(int i = 0; i < n; i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			list.get(index).add(i);
		}
		int result = n;
		for(List<Integer>l: list) {
			if(l != null && l.size() == 1 && l.get(0) < result) {
				result = l.get(0);
			}
		}
		if (result == n) {
			result = -1;
		}
		return result;
	}
}
