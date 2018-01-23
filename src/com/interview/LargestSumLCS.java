package com.interview;

public class LargestSumLCS {

	public static void main(String[] args) {
		LargestSumLCS ls = new LargestSumLCS();
		System.out.println(ls.largestSumLCS(new int[] {1, 3, 2, 4, 6, 5, 7}));
	}

	public int largestSumLCS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] sums = new int[n], lens = new int[n];
		lens[0] = 1;
		sums[0] = nums[0];
		int maxId = 0;
		for (int i = 1; i < n; i++) {
			int id = i;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] >= nums[j]) {
					if (lens[j] > lens[id] || (lens[j] == lens[id] && sums[j] > sums[id])) {
						id = j;
					}
				}
			}
			sums[i] = sums[id] + nums[i];
			lens[i] = lens[id] + 1;
			if (lens[i] > lens[maxId] || (lens[i] == lens[maxId] && sums[i] > sums[maxId])) {
				maxId = i;
			}
		}
		return sums[maxId];
	}
}
