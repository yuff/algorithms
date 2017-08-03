package com.leetcode.mytest;

public class Base7 {
	public static void main(String[] args) {
		Base7 b7 = new Base7();
		System.out.println(b7.convertToBase7(105));
		System.out.println(b7.convertToBase7(-7));
	}

	public String convertToBase7(int num) {
		StringBuilder b = new StringBuilder();
		boolean isMinus = false;
		if (num < 0) {
			isMinus = true;
			num = -num;
		}
		int[] c;
		int count = 0;
		int tmp = num;
		int minus = 1;
		while (tmp / 7 > 0) {
			count++;
			minus *= 7;
			tmp /= 7;
		}
		if (count > 0) {			
			num -= (minus * tmp);
		}
		int cLen = count + 1;
		c = new int[cLen];
		c[count] = tmp;
		while (num >= 7) {
			count = 0;
			tmp = num;
			minus = 1;
			while (tmp / 7 > 0) {
				count++;
				minus *= 7;
				tmp /= 7;
			}
			num -= (minus * tmp);
			c[count] = tmp;
		}
		c[0] = num;
		if (isMinus) {
			b.append("-");
		}
		for (int i = cLen - 1; i >= 0; i--) {
			b.append(c[i]);
		}
		return b.toString();
	}
}
