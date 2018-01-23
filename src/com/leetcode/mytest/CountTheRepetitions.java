package com.leetcode.mytest;

public class CountTheRepetitions {
	public static void main(String[] args) {
		CountTheRepetitions ctr = new CountTheRepetitions();
		System.out.println(ctr.getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf",
		                                         10000,
		                                         "xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly",
		                                         100));
	}

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (s1 == null || s2 == null || n1 == 0 || n2 == 0) {
			return 0;
		}
		int[] rep = findRepetition(s1, n1, s2);
		int m = (n1 / rep[0]) * rep[1];
		int r = n1 % rep[0];
		int rc = findRepetition(s1, r, s2)[1];
		return (m + rc) / n2;
	}

	private int[] findRepetition(String s, int n1, String t) {
		int i = 0, j = 0, m = s.length(), n = t.length();
		boolean found = false;
		while (!found && i < m * n1) {
			char c1 = s.charAt(i % m);
			char c2 = t.charAt(j % n);
			if (c1 == c2) {
				i++;
				j++;
			}
			else {
				i++;
			}
			if (i % m == 0 && j % n == 0) {
				found = true;
			}
		}
		return new int[] {i / m, j / n};
	}
}
