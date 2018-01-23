package com.leetcode.mytest;

public class PlusOne {
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(new int[] {1, 9, 8});
		for (int i : result) {
			System.out.print(i);
		}
	}

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		int n = digits.length;
		int[] result = new int[n + 1];
		boolean addOne = true;
		for (int i = n; i > 0; i--) {
			int pre = digits[i - 1];
			if (addOne) {
				pre += 1;
				result[i] = pre % 10;
				addOne = pre / 10 > 0;
			}
			else {
				result[i] = pre;
			}
		}
		if (addOne) {
			result[0] = 1;
			return result;
		}
		else {
			int[] res = new int[n];
			System.arraycopy(result, 1, res, 0, n);
			return res;
		}
	}
}
