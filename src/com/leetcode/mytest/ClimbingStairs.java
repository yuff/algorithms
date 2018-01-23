package com.leetcode.mytest;

public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(45));
		System.out.println(cs.climbStairs1(45));
	}
    public int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int one = 1;
        int two = 1;
        for(int i = 2; i <= n; i++) {
        	int tmp = one + two;
        	one = two;
        	two = tmp;
        }
        return two;
    }
}
