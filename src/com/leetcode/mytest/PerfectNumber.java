package com.leetcode.mytest;

public class PerfectNumber {
	public static void main(String[] args) {
		PerfectNumber pn = new PerfectNumber();
		System.out.println(pn.checkPerfectNumber(1));
	}
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1, div = (int) Math.sqrt(num);
        for(int i = 2; i <= div; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num/i;
            }
        }
        return sum == num;
    }
}
