package com.leetcode.mytest;

public class KEmptySlots {

	public static void main(String[] args) {
		KEmptySlots ks = new KEmptySlots();
		System.out.println(ks.kEmptySlots(new int[] {1, 3, 2}, 1));
		System.out.println(ks.kEmptySlots(new int[] {1, 2, 3}, 1));
		System.out.println(ks.kEmptySlots(new int[] {4, 6, 1, 5, 3, 2}, 2));
	}

	public int kEmptySlots(int[] flowers, int k) {
		if (flowers == null || flowers.length < k + 2) {
			return -1;
		}
		int n = flowers.length;
		boolean[] blooming = new boolean[n];
		if (n == 0) {
			return -1;
		}
		blooming[flowers[0] - 1] = true;
		for (int i = 1; i < n; i++) {
			blooming[flowers[i] - 1] = true;
			boolean r = checkIfExist(blooming, flowers[i] - 1, k);
			if (r) {
				return i + 1;
			}
		}
		return -1;
	}

	private boolean checkIfExist(boolean[] blooming, int pos, int k) {
		int n = blooming.length;
		int s = pos - k - 1;
		if (s >= 0 && blooming[s]) {
			int i = s + 1;
			while (i < pos) {
				if (blooming[i]) {
					break;
				}
				i++;
			}
			if (i == pos) {
				return true;
			}
		}
		int e = pos + k + 1;
		if (e < n && blooming[e]) {
			int i = pos + 1;
			while (i < e) {
				if (blooming[i]) {
					break;
				}
				i++;
			}
			if (i == e) {
				return true;
			}
		}
		return false;
	}
}
