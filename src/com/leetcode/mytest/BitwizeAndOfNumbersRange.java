package com.leetcode.mytest;

public class BitwizeAndOfNumbersRange {
	public static void main(String[] args) {
		BitwizeAndOfNumbersRange ba = new BitwizeAndOfNumbersRange();
		System.out.println(ba.rangeBitwiseAnd(5, 7));
	}
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n == 0 || m * 2 < n) {
            return 0;
        }
        int m1 = 1, n1 = 1;
        while (m /2 > 0) {
            m1 *= 2;
            m /= 2;
        }
        while(n /2 > 0) {
            n1 *= 2;
            n /=2;
        }
        if (m1 == n1) {
            return m1;
        } else {
            return 0;
        }
    }
}
