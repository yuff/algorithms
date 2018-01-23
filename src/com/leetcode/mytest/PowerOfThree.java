package com.leetcode.mytest;

public class PowerOfThree {
	public static void main(String[] args) {
		PowerOfThree pot = new PowerOfThree();
		System.out.println(pot.isPowerOfThree(0));
		System.out.println(pot.isPowerOfThree(1));
		System.out.println(pot.isPowerOfThree(4));
	}

	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}
		boolean result = true;
		while (n > 0 && n != 1) {
			if (n % 3 != 0) {
				result = false;
				break;
			}
			else {
				n = n / 3;
			}
		}
		return result;
	}
}
