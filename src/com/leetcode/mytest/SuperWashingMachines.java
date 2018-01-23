package com.leetcode.mytest;

public class SuperWashingMachines {
	public static void main(String[] args) {
		SuperWashingMachines swm = new SuperWashingMachines();
		System.out.println(swm.findMinMoves(new int[] {0, 0, 10, 0, 0, 0, 10, 0, 0, 0}));
		// System.out.println(5000 == swm.findMinMoves(new int[] {100000, 0, 100000, 0, 100000, 0,
		// 100000, 0, 100000, 0, 100000,
		// 0}));
		// System.out.println(5 == swm.findMinMoves(new int[] {10, 0, 10, 0, 10, 0, 10, 0, 10, 0,
		// 10, 0}));
		// System.out.println(8 == swm.findMinMoves(new int[] {0, 0, 11, 5}));
		// System.out.println(2 == swm.findMinMoves(new int[] {0, 2, 4}));
		// System.out.println(3 == swm.findMinMoves(new int[] {1, 0, 5}));
		// System.out.println(2 == swm.findMinMoves(new int[] {0, 3, 0}));
		// System.out.println(-1 == swm.findMinMoves(new int[] {0, 2, 0}));
	}

	public int findMinMoves(int[] machines) {
		if (machines == null || machines.length == 0) {
			return 0;
		}
		int n = machines.length, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += machines[i];
		}
		if (sum % n != 0) {
			return -1;
		}
		int ave = sum / n, distance = 0;
		for (int i = 0; i < n; i++) {
			if (machines[i] < ave) {
				distance += (ave - machines[i]);
			}
		}
		int count = 0;
		while (distance > 0) {
			boolean[] pre = new boolean[n];
			// System.arraycopy(machines, 0, pre, 0, n);
			for (int i = 0; i < n; i++) {
				int cur = machines[i];
				if (cur <= ave) {
					continue;
				}
				else {
					int id = findIndex(machines, pre, ave, i);
					if (id >= 0) {
						pre[i] = true;
						machines[i] -= 1;
						machines[id] += 1;
						distance--;
					}
				}
			}
			count++;
		}
		return count;
	}

	private int findIndex(int[] machines, boolean[] pre, int ave, int i) {
		int id = -1, n = machines.length;
		if (i == 0) {
			int id1 = i + 1;
			while (id1 < n) {
				if (machines[id1] > ave || (machines[id1] == ave && pre[id1])) {
					break;
				}
				else if (machines[id1] < ave) {
					id = id1;
					if (machines[id1] == 0) {
						break;
					}
				}
				id1++;
			}
			return id;
		}
		else if (i == n - 1) {
			int id2 = i - 1;
			while (id2 >= 0) {
				if (machines[id2] > ave || (machines[id2] == ave && pre[id2])) {
					break;
				}
				else if (machines[id2] < ave) {
					id = id2;
					if (machines[id2] == 0) {
						break;
					}
				}
				id2--;
			}
			return id;
		}
		else {
			int id1 = i + 1;
			while (id1 < n) {
				if (machines[id1] > ave || (machines[id1] == ave && pre[id1])) {
					id1 = -1;
					break;
				}
				else if (machines[id1] < ave) {
					id = id1;
					if (machines[id1] == 0) {
						break;
					}
				}
				id1++;
			}
			int id2 = i - 1;
			while (id2 >= 0) {
				if (machines[id2] > ave || (machines[id2] == ave && pre[id2])) {
					id2 = -1;
					break;
				}
				else if (machines[id2] == 0) {
					if (id1 == -1 || (i - id2) > (id1 - i)) {
						id = id2;
					}
					break;
				}
				else if (machines[id2] < ave) {
					if (id1 == -1 || (i - id2) > (id1 - i)) {
						id = id2;
					}
				}
				id2--;
			}
			return id;
		}
	}

	private int findIndex1(int[] machines, boolean[] pre, int ave, int i) {
		int id = -1;
		int n = machines.length;
		if ((i > 0 && machines[i - 1] < ave) || (i < n - 1 && machines[i + 1] < ave)) {
			if (i <= 0) {
				id = i + 1;
			}
			else if (i >= n - 1) {
				id = i - 1;
			}
			else if (machines[i - 1] <= machines[i + 1]) {
				id = i - 1;
			}
			else {
				id = i + 1;
			}
		}
		else {
			int id1 = i - 1, id2 = i + 1;
			while (id1 >= 0) {
				if (machines[id1] > ave) {
					id = -1;
					break;
				}
				else if (machines[id1] == ave) {
					if (pre[id1]) {
						break;
					}
					else {
						id1--;
					}
				}
				else {
					id = id1;
					break;
				}
			}
			while (id2 < n) {
				if (machines[id2] == ave) {
					if (pre[id2]) {
						break;
					}
					else {
						id2++;
					}
				}
				else {
					if (machines[id2] > ave) {
						break;
					}
					else if (id >= 0) {
						if (pre[id2] && !pre[id]) {
							break;
						}
						else if ((pre[id] && !pre[id2]) || machines[id2] < machines[id]) {
							id = id2;
						}
					}
					else {
						id = id2;
					}
					break;
				}
			}
		}
		return id;
	}
}
