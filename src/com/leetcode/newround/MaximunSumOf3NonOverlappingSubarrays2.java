package com.leetcode.newround;

public class MaximunSumOf3NonOverlappingSubarrays2 {
	public static void main(String[] args) {
		MaximunSumOf3NonOverlappingSubarrays2 mm = new MaximunSumOf3NonOverlappingSubarrays2();
		int[] nums = new int[] {7, 13, 20, 19, 19, 2, 10, 1, 1, 19};
		int[] r = mm.maxSumOfThreeSubarrays(nums, 3);
		for (int i : r) {
			System.out.print(i + ",");
		}
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		return maxSumOfThreeSubarrays(nums, k, 3);
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k, int counts) {
		if (nums == null || nums.length < counts * k || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] sums = new int[n];
		calSums(sums, nums, k);
		int[][] sumOfK = new int[n][counts + 1];
		int[][] ids = new int[n][counts + 1];
		for (int i = n - k; i >= 0; i--) {
			if (i == n - k) {
				sumOfK[i][1] = sums[n - 1] - sums[i - 1];
				ids[i][1] = i;
			}
			else {
				int preSum = sumOfK[i + 1][1];
				int max = sums[i + k - 1] - (i > 0 ? sums[i - 1] : 0);
				if (max >= preSum) {
					sumOfK[i][1] = max;
					ids[i][1] = i;
				}
				else {
					sumOfK[i][1] = preSum;
					ids[i][1] = ids[i + 1][1];
				}
			}
		}
		for (int c = 2; c <= counts; c++) {
			int eId = n - c * k;
			sumOfK[eId][c] = sums[n - 1] - (eId == 0 ? 0 : sums[eId - 1]);
			ids[eId][c] = eId;
			for (int i = eId - 1; i >= 0; i--) {
				int preSum = sumOfK[i + 1][c];
				int max = sums[i + k - 1] - (i == 0 ? 0 : sums[i - 1]) + sumOfK[i + k][c - 1];
				if (max >= preSum) {
					sumOfK[i][c] = max;
					ids[i][c] = i;
				}
				else {
					sumOfK[i][c] = preSum;
					ids[i][c] = ids[i + 1][c];
				}
			}
		}
		int[] result = new int[counts];
		int id = ids[0][counts];
		result[0] = id;
		int i = 1;
		while (i < counts) {
			id = ids[id + k][counts - i];
			result[i++] =id;
		}
		return result;
	}

	private void calSums(int[] sums, int[] nums, int k) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
	}
}
