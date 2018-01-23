package com.leetcode.mytest;

public class SolveTheEquation {
	public static void main(String[] args) {
		SolveTheEquation ste = new SolveTheEquation();
		System.out.println(ste.solveEquation("x+5-3+x=6+x-2"));
		 System.out.println(ste.solveEquation("x=x"));
		 System.out.println(ste.solveEquation("2x=x"));
		 System.out.println(ste.solveEquation("2x+3x-6x=x+2"));
		 System.out.println(ste.solveEquation("x=x+2"));
	}

	public String solveEquation(String equation) {
		if (equation == null || equation.isEmpty()) {
			return equation;
		}
		String[] strs = equation.split("=");
		int[] left = parse(strs[0]);
		int[] right = parse(strs[1]);
		int a = left[0] - right[0];
		int b = right[1] - left[1];
		if (a == 0 && b == 0) {
			return "Infinite solutions";
		}
		else if (a == 0 && b != 0) {
			return "No solution";
		}
		else {
			return "x=" + (b / a);
		}
	}

	private int[] parse(String str) {
		int[] result = new int[2];
		int n = str.length();
		StringBuilder builder = null;
		int i = 0;
		boolean start = false, isNegative = false;
		while (i < n) {
			char c = str.charAt(i);
			if (!start) {
				start = true;
				builder = new StringBuilder();
				if (c == '-' || c == '+') {
					isNegative = c == '-';
				}
				else {
					builder.append(c);
				}
				i++;
			}
			else {
				if (c == '-' || c == '+') {
					process(builder.toString(), isNegative, result);
					start = false;
				}
				else {
					builder.append(c);
					i++;
				}
			}
		}
		process(builder.toString(), isNegative, result);
		return result;
	}

	private void process(String str, boolean isNegative, int[] result) {
		int coef = isNegative ? -1 : 1;
		if ('x' == str.charAt(str.length() - 1)) {
			int tmp = 1;
			if (str.length() > 1) {
				tmp = Integer.valueOf(new String(str.toCharArray(), 0, str.length() - 1));
			}
			result[0] += coef * tmp;
		}
		else {
			result[1] += coef * Integer.valueOf(str);
		}
	}
}
