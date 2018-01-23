package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.generate(11));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> first = new ArrayList<>();
		first.add(1);
		result.add(first);
		if (numRows == 1) {
			return result;
		}
		for (int i = 1; i < numRows; i++) {
			result.add(generate(result.get(i - 1)));
		}
		return result;
	}

	private List<Integer> generate(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		int one = 0, two = 1;
		int n = list.size();
		while (two < n) {
			result.add(list.get(one) + list.get(two));
			one = two;
			two = two + 1;
		}
		result.add(1);
		return result;
	}
}
