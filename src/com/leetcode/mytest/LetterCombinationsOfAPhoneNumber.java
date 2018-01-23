package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		System.out.println(lc.letterCombinations("234"));
	}

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.isEmpty()) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<>();
		int n = digits.length();
		char[] tmp = new char[n];
		String[] strs = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		combine(result, tmp, 0, digits, strs);
		return result;
	}

	private void combine(List<String> result, char[] tmp, int id, String digits, String[] strs) {
		if (id == tmp.length) {
			result.add(new String(tmp));
			return;
		}
		int d = digits.charAt(id) - '0';
		String replace = strs[d];
		for (int j = 0; j < replace.length(); j++) {
			tmp[id] = replace.charAt(j);
			combine(result, tmp, id + 1, digits, strs);
		}
	}
}
