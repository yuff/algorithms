package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(2));
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateStr(result, "", 0, 0, n);
		return result;
	}

	private void generateStr(List<String> result, String str, int i, int j, int n) {
		if (str.length() == n * 2) {
			result.add(str);
			return;
		}
		if (i < n) {
			generateStr(result, str + "(", i + 1, j, n);
		}
		if (j < i) {
			generateStr(result, str + ")", i, j + 1, n);
		}

	}
}
