package com.leetcode.mytest;

public class RotateFunction {
	public static void main(String[] args) {
		RotateFunction rf = new RotateFunction();
		System.out.println(rf.maxRotateFunction(new int[] {4, 3, 2, 6}));
	}
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = sumRotate(A, 0);
        for(int i = 1; i < n; i++) {
            int r = sumRotate(A, i);
            if (r > sum) {
                sum = r;
            }
        }
        return sum;
    }
    private int sumRotate(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += i * nums[(i + k) % n];
        }
        return sum;
    }
}
