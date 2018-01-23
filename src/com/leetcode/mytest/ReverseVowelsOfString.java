package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfString {
	public static void main(String[] args) {
		ReverseVowelsOfString rv = new ReverseVowelsOfString();
		System.out.println(rv.reverseVowels("hello"));
		System.out.println(rv.reverseVowels("leetcode"));
	}

	public String reverseVowels(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		int n = s.length();
		char[] arr = s.toCharArray();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (isVowel(s.charAt(i))) {
				list.add(i);
			}
		}
		int f = 0, e = list.size() - 1;
		while (f < e) {
			char c = arr[list.get(f)];
			arr[list.get(f)] = arr[list.get(e)];
			arr[list.get(e)] = c;
			f++;
			e--;
		}
		return new String(arr);
	}

	private boolean isVowel(char c) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		for (char v : vowels) {
			if (v == c) {
				return true;
			}
		}
		return false;
	}
}
