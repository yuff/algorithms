package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		System.out.println(pt.getRow(3));
		System.out.println(pt.getRow(4));
	}
	public List<Integer> getRow(int rowIndex) {
		int[] result = new int[rowIndex + 1];
		if (rowIndex == 0) {
			result[0] = 1;
		}
		else {
			result[0] = 1;
			result[1] = 1;
			for (int r = 2; r <= rowIndex; r++) {
				int pre1 = result[0];
				int pre2 = result[1];
				for (int i = 1; i < r; i++) {
					result[i] = pre1 + pre2;
					pre1 = pre2;
					pre2 = result[i + 1];
				}
				result[r] = 1;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i : result) {
			res.add(i);
		}
		return res;
	}
}
