package com.leetcode.mytest;

public class SumOfSquareNumber {

	public static void main(String[] args) {
		SumOfSquareNumber sosn = new SumOfSquareNumber();
		System.out.println(sosn.judgeSquareSum(5));
		System.out.println(sosn.judgeSquareSum(3));
		System.out.println(sosn.judgeSquareSum(20));
	}
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        if (sqrt * sqrt == c) {
        	return true;
        }
        for(int i = sqrt; i >= 0; i--) {
        	int a = i * i;
        	int b = c - a;
        	int t = (int)Math.sqrt(b);
        	if ( b == t * t) {
        		return true;
        	}
        }
        return false;
    }
}
