package com.leetcode.mytest;

public class ComplexNumberMultiplication {
	public static void main(String[] args) {
		String a = "1+1i";
		String result = new ComplexNumberMultiplication().complexNumberMultiply(a, a);
		System.out.println(result);
	}

	public String complexNumberMultiply(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		String[] aStrs = a.split("\\+");
		String[] bStrs = b.split("\\+");
		if (aStrs.length != 2 || bStrs.length != 2) {
			return null;
		}
		int ax = Integer.valueOf(aStrs[0]);
		int ay = Integer.valueOf(aStrs[1].substring(0, aStrs[1].length() - 1));
		int bx = Integer.valueOf(bStrs[0]);
		int by = Integer.valueOf(bStrs[1].substring(0, bStrs[1].length() - 1));
		int rx = ax * bx - ay * by;
		int ry = ax * by + ay * bx;
		StringBuilder builder = new StringBuilder();
		builder.append(rx);
		builder.append("+");
		builder.append(ry);
		builder.append("i");
		return builder.toString();
	}
}
