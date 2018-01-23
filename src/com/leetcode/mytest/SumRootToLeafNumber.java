package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SumRootToLeafNumber {
	public static void main(String[] args) {
		SumRootToLeafNumber srt = new SumRootToLeafNumber();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		System.out.println(srt.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		return sumNumber(root.val, root);
	}

	private int sumNumber(int sum, TreeNode node) {
		int left = 0, right = 0;
		if (node.left != null) {
			left = sumNumber(sum * 10 + node.left.val, node.left);
		}
		if (node.right != null) {
			right = sumNumber(sum * 10 + node.right.val, node.right);
		}
		if (left != 0 || right != 0) {
			return left + right;
		}
		else {
			return sum;
		}
	}
}
