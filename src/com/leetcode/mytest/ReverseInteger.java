package com.leetcode.mytest;

public class ReverseInteger {
	public static void main(String[] args) {
		int a = 1534236469;
		System.out.println(reverse(a));
	}
	 public static int reverse(int x) {
	        if (x == 0) {
	            return 0;
	        }
	        int[] bits = new int[10];
	        boolean isMinus = x < 0 ? true : false;
	        int index = 0;
	        int ax = Math.abs(x);
	        while(ax > 0) {
	            bits[index++] = ax % 10;
	            ax = ax/10;
	        }
	        int pow = index - 1;
	        int result = 0;
	        if (pow < 9) {
	            for (int i = 0; i < index; i++) {
	                 result += bits[i] * Math.pow(10, pow - i);
	            }
	           
	        } else {
	            try {
	               for (int i = 0; i < index; i++) {
	                    result = Math.addExact( result,Math.multiplyExact(bits[i], (int)Math.pow(10, pow - i)));
	                }
	            } catch(ArithmeticException e) {
	                result = 0;
	                isMinus = false;
	            }
	        }
	         return isMinus? -result : result;
	    }
}
