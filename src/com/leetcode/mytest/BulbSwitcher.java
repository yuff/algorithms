package com.leetcode.mytest;

public class BulbSwitcher {

	public static void main(String[] args) {
		BulbSwitcher bs = new BulbSwitcher();
		System.out.println(bs.bulbSwitch(999999));
	}

	public int bulbSwitch(int n) {
		if (n == 0) {
			return 0;
		}
		int count = 1;
		for( int i = 2; i <=n;i++) {
			int s = (int) Math.sqrt(i);
			if (i % s == 0 && i / s == s) {
				count++;
			}
		}
		return count;
	}

}
