package com.leetcode.mytest;

import java.util.LinkedList;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class LongestUnivaluePath {
	public static void main(String[] args) {
		LongestUnivaluePath lu = new LongestUnivaluePath();
		TreeNode root = CommonUtil.buildTree(new Integer[] {26, 26, 26, 26, 26, 24, 26, 25, 25, 25, 27, 23, 25, 25, 27,
		                                                    24, 26, 24, 26, 24, 24, null, 28, null, null, 26, null,
		                                                    null, 26, 26, 28, 25, null, 25, 27, null, null, null, null,
		                                                    null, 23, null, null, 29, 27, null, null, null, null, 25,
		                                                    null, 27, 27, 24, 26, 24, 26, 26, 26, null, 22, 28, null,
		                                                    26, 26, null, null, 26, null, 28, 28, 25, null, null, null,
		                                                    25, 25, 25, 27, 25, 25, 27, 25, null, null, null, null,
		                                                    null, null, null, 27, 27, 27, null, null, 27, 29, 24, 26,
		                                                    26, 26, null, 26, null, 26, null, null, null, 24, 24, 24,
		                                                    null, 26, 24, 26, null, null, null, 26, null, null, null,
		                                                    28, null, 30, null, 23, 27, null, null, null, null, null,
		                                                    null, null, null, null, null, null, 23, 25, 25, 25, 27, 25,
		                                                    23, 25, null, null, null, null, null, null, 29, null, null,
		                                                    null, 26, null, 22, null, null, 26, 24, 26, null, 26, 28,
		                                                    null, null, 26, 22, null, null, null, null, null, null,
		                                                    null, null, null, null, 25, 23, null, null, null, null,
		                                                    27});
		System.out.println(lu.longestUnivaluePath(root));
	}

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		int result = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int left = node.left == null ? 0 : longestUP(node.left, node.val, stack);
			int right = node.right == null ? 0 : longestUP(node.right, node.val, stack);
			int tmp = left + right;
			if (tmp > result) {
				result = tmp;
			}
		}
		return result;
	}

	private int longestUP(TreeNode node, int val, LinkedList<TreeNode> stack) {
		if (node.val == val) {
			int left = node.left == null ? 0 : longestUP(node.left, val, stack);
			int right = node.right == null ? 0 : longestUP(node.right, val, stack);
			return left > right ? left + 1 : right + 1;
		}
		else {
			stack.push(node);
			return 0;
		}
	}
}
