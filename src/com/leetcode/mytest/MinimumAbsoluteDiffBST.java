package com.leetcode.mytest;

import java.util.Stack;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between
 * values of any two nodes. Definition for a binary tree node. public class TreeNode { int val;
 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class MinimumAbsoluteDiffBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(236);
		root.left = new TreeNode(104);
		root.right = new TreeNode(701);
		root.left.right = new TreeNode(227);
		root.right.right = new TreeNode(911);
		System.out.println(getMinimumDifference(root));
	}

	public static int getMinimumDifference(TreeNode root) {
		int result = Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode current = root;
//		List<Integer> list = new ArrayList<>();
		int lastNum = 0;
		int listSize = 0;
		while (current.left != null) {
			stack.push(current.left);
			current = current.left;
		}
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (listSize > 0) {
				int abs = Math.abs(lastNum - current.val);
				if (abs < result) {
					result = abs;
				}
				lastNum = current.val;
			} else {
				lastNum = current.val;
				listSize++;
			}
//			list.add(current.val);
			listSize++;
			if (current.right != null) {
				current = current.right;
				stack.push(current);
				while (current.left != null) {
					stack.push(current.left);
					current = current.left;
				}
			}
		}
		return result;
	}
}

