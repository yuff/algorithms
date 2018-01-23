package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class MaximumBinaryTree {
	public static void main(String[] args) {
		MaximumBinaryTree mb = new MaximumBinaryTree();
		CommonUtil.print(mb.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
	}
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

	private TreeNode buildTree(int[] nums, int s, int e) {
		if (s > e) {
			return null;
		}
		int id = s;
		for(int i = s + 1; i <=e; i++) {
			if (nums[i] > nums[id]) {
				id = i;
			}
		}
		TreeNode node = new TreeNode(nums[id]);
		node.left = buildTree(nums, s, id - 1);
		node.right = buildTree(nums, id + 1, e);
		return node;
	}
}
