package com.leetcode.mytest;

public class AddStrings {
	public static void main(String[] args) {
		AddStrings as = new AddStrings();
		System.out.println(as.addStrings("99", "9"));
	}

	public String addStrings(String num1, String num2) {
		if (num1 == null) {
			return num2;
		}
		if (num2 == null) {
			return num1;
		}
		int len1 = num1.length();
		int len2 = num2.length();
		int len = Math.max(len1, len2) + 1;
		char[] res = new char[len];
		int cbit = 0;
		for (int i = len - 1, i1 = len1 - 1, i2 = len2 - 1; i > 0; i--, i1--, i2--) {
			int t1 = 0, t2 = 0;
			if (i1 >= 0) {
				t1 = num1.charAt(i1) - '0';
			}
			if (i2 >= 0) {
				t2 = num2.charAt(i2) - '0';
			}
			int sum = t1 + t2 + cbit;
			res[i] = (char) (sum % 10 + '0');
			cbit = sum / 10;
		}
		if (cbit > 0) {
			res[0] = (char) (cbit + '0');
			return new String(res);
		}
		else {
			return new String(res, 1, len - 1);
		}
	}
}
