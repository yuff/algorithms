package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode root = CommonUtil.buildTree(new int[] {4, 1, 8, 0, 2});
		System.out.println(bbt.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = 0, right = 0;
		if (root.left != null) {
			left = height(root.left);
		}
		if (root.right != null) {
			right = height(root.right);
		}
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return false;
		}
		return true;
	}

	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = 0, right = 0;
		if (node.left != null) {
			left = height(node.left);
		}
		if (node.right != null) {
			right = height(node.right);
		}
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		else {
			return Math.max(left, right) + 1;
		}
	}
}
