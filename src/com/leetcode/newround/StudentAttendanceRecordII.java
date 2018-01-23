package com.leetcode.newround;

public class StudentAttendanceRecordII {
	public static void main(String[] args) {
		StudentAttendanceRecordII sa = new StudentAttendanceRecordII();
		System.out.println(sa.checkRecord(8));
	}

	public int checkRecord(int n) {
		if (n == 0) {
			return 0;
		}
		int m = 1000000007;
		// 0:A, 1:L,2:P
		int[] a = new int[n];
		int[] l = new int[n];
		int[] p = new int[n];
		a[0] = 1;
		a[1] = 2;
		a[2] = 4;
		p[0] = 1;
		l[0] = 1;
		l[1] = 3;
		for(int i = 1; i < n; i++) {
			p[i] = (p[i - 1] % m + a[i - 1]% m + l[i - 1]% m) % m;
			if (i > 1) {
				l[i] = (a[i - 1] % m+ p[i - 1] % m+ a[i - 2] % m+ p[i - 2]% m)% m;
			}
			if ( i > 2) {
				a[i] = (a[i - 1] % m+ a[i - 2] % m+ a[i - 3]% m)% m;
			}
		}
		return (a[n - 1] + p[n - 1]+ l[n - 1])% m;
	}
}
