package com.leetcode.mytest;

public class GuessNumberHigherOrLower {
    public int getMoneyAmount(int n) {
        if (n == 1) {
        	return 0;
        }
        int sum = 0, low = 1, high = n, mid = (low + high) >> 1;
        while (low < high) {
        	sum += mid;
        	low = mid + 1;
        	mid = (high + low) >> 1;
        }
        return sum; 
    }
}
