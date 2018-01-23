package com.leetcode.newround;

public class GasStation {
	public static void main(String[] args) {
		GasStation gs = new GasStation();
		int[] gas = new int[] {3, 4};
		int[] cost = new int[] {3, 4};
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		int n = gas.length;
		int[] remain = new int[n];
		for (int i = 0; i < n; i++) {
			remain[i] = gas[i] - cost[i];
		}
		for (int i = 0; i < n; i++) {
			int count = 0, g = remain[i];
			while (g >= 0 && count < n) {
				g += remain[(i + count + 1) % n];
				count++;
			}
			if (count == n) {
				return i;
			}
		}
		return -1;
	}
}
