package com.leetcode.newround;

public class BurstBalloons {
	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		System.out.println(bb.maxCoins(new int[]{3,1,5,8}));
	}
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] b = new int[n][n];

        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int maxBurst = 0;
                for(int k = i ; k <= j; k++) {
                	int left = i == 0? 1: nums[i - 1], right = j == n - 1? 1: nums[j + 1];
                	int tmp = left * nums[k] * right;
                	if (k != i) {
                		tmp += b[i][k - 1];
                	}
                	if (k != j) {
                		tmp += b[k + 1][j];
                	}
                	maxBurst = Math.max(maxBurst, tmp);
                }
                b[i][j] = maxBurst;
            }
        }
        return b[0][n-1];
    }
}
