package com.leetcode.mytest;

public class IntegerPalindrom {
	public static void main(String[] args) {
		int a = 123321;
		int b = 123454321;
		System.out.println(isPalindrome(a));
		System.out.println(isPalindrome(21120));
	}
	 public static boolean isPalindrome(int x) {
	        if (x < 0 || x %10 == 0) {
	            return false;
	        } else if (x < 10 ) {
	            return true;
	        } else {
	            int y = 0; 
	            while (x > 0 && x > y) {
	                y = y * 10 + x % 10;
	                x = x/10; 
	                if (x == y || x/10 == y) {
	                    return true;
	                }
	            }
	            return false;
	        }
	    }
}
