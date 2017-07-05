package com.leetcode.mytest;

public class CountingBit {
	public static void main(String[] args) {
		int[] result = new CountingBit().countBits(4);
		for(int i: result) {
			System.out.println(i);
		}
	}
	 public int[] countBits(int num) {
	        if(num == 0) {
	            return null;
	        }
	        int[] result = new int[num + 1];
	        if (num == 1) {
	            result[0] = 0;
	            result[1] = 1;
	        } else if (num > 1) {
	            result[0] = 0;
	            result[1] = 1;
	            for (int i = 2; i <= num; i++) {
	                int count = result[i >> 1] + (num & 1);
	                result[i] = count;
	            }
	        }
	        return result;
	    }
}
