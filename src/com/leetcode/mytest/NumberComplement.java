package com.leetcode.mytest;

public class NumberComplement {

	public static void main(String[] args) {
		int a = 1;
		System.out.println(numberComplement(a));
	}
	
	public static int numberComplement(int num) {
		int result = 0;
		int bit = 0;
		while (num != 0) {
			if ((num & 1 ) == 0) {
				result += Math.pow(2, bit);
			}
			bit++;
			num = num >> 1;
		}
		return result;
	}
}
