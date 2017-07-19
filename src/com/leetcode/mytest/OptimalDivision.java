package com.leetcode.mytest;

public class OptimalDivision {
	public static void main(String[] args) {
		OptimalDivision od = new OptimalDivision();
		int[] nums = new int[] {6,2,3,4,5};
		System.out.println(od.optimalDivision(nums));
	}

	public String optimalDivision(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		return maxResult(nums, 0);
	}

	private String maxResult(int[] nums, int start) {
		StringBuilder builder = new StringBuilder();
		int length = nums.length;
		if (start >= length) {
			return "";
		}
		builder.append(nums[start]);
		if (start == length - 1) {
			return builder.toString();
		}
		else if (start == length - 2) {
			builder.append("/");
			builder.append(nums[length - 1]);
		}
		else {
			builder.append("/");
			builder.append(minResult(nums, start + 1));
		}
		return builder.toString();
	}

	private String minResult(int[] nums, int start) {
		StringBuilder builder = new StringBuilder();
		boolean needParenthesis = false;
		int length = nums.length;
		if (start + 1 < length) {
			needParenthesis = true;
			builder.append("(");
		}
		builder.append(nums[start]);
		builder.append("/");
		builder.append(maxResult(nums, start + 1));
		if (needParenthesis) {			
			builder.append(")");
		}
		return builder.toString();
	}
}
