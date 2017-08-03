package com.leetcode.mytest;

public class FractionAdditionAndSubtraction {

	public static void main(String[] args) {
		FractionAdditionAndSubtraction fa = new FractionAdditionAndSubtraction();
		System.out.println(fa.fractionAddition("-1/2+4/5"));
	}

	public String fractionAddition(String expression) {
		if (expression == null || expression.isEmpty()) {
			return expression;
		}
		String[] strs = expression.split("\\+|\\-");
		String[] syms = expression.split("[0-9]+/[0-9]+");
		int length = syms.length == 0 ? 1 : syms.length;
		int[] deno = new int[length];
		int[] nums = new int[length];
		int index = 0;
		for (String s : strs) {
			if (s != null && !s.isEmpty()) {
				String[] tmp = s.split("/");
				deno[index] = Integer.valueOf(tmp[1]);
				nums[index] = Integer.valueOf(tmp[0]);
				index++;
			}
		}
		int minCM = mcm(deno);
		multiMinCM(minCM, deno, nums);
		int num = 0;
		for (int i = 0; i < length; i++) {
			if (syms.length == 0 || syms[i] == null || syms[i].isEmpty() || "+".equals(syms[i])) {
				num += nums[i];
			}
			else if ("-".equals(syms[i])) {
				num -= nums[i];
			}
		}
		boolean isMinus = false;
		if (num != 0) {
			if (num < 0) {
				isMinus = true;
				num = (-num);
			}
			int maxCD = mcd(minCM, num);
			minCM /= maxCD;
			num /= maxCD;
		}
		else {
			minCM = 1;
		}

		StringBuilder builder = new StringBuilder();
		if (isMinus) {
			builder.append("-");
		}
		builder.append(num);
		builder.append("/");
		builder.append(minCM);
		return builder.toString();
	}

	private int mcd(int a, int b) {
		int min = a;
		int max = b;
		if (a > b) {
			min = b;
			max = a;
		}
		while (max % min != 0) {
			int tmp = min;
			min = max % min;
			max = tmp;
		}
		return min;
	}

	private void multiMinCM(int minCM, int[] deno, int[] nums) {
		int length = deno.length;
		for (int i = 0; i < length; i++) {
			nums[i] *= (minCM / deno[i]);
		}
	}

	private int mcm(int[] deno) {
		if (deno.length == 1) {
			return deno[0];
		}
		int initial = (deno[0] * deno[1]) / mcd(deno[0], deno[1]);
		int len = deno.length;
		for (int i = 2; i < len; i++) {
			initial = (initial * deno[i]) / mcd(initial, deno[i]);
		}
		return initial;
	}
}
