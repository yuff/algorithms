package com.leetcode.mytest;

import java.util.LinkedList;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class DiaMeterOfBinaryTree {

	public static void main(String[] args) {
		DiaMeterOfBinaryTree dobt = new DiaMeterOfBinaryTree();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		System.out.println(dobt.diameterOfBinaryTree(root));
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		int dia = 0;
		while (!stack.isEmpty()) {
			int left = 0, right = 0;
			TreeNode node = stack.pollLast();
			if (node.left != null) {
				left = height(node.left);
				stack.add(node.left);
			}
			if (node.right != null) {
				right = height(node.right);
				stack.add(node.right);
			}
			int tmp = left + right;
			if (tmp > dia) {
				dia = tmp;
			}
		}
		return dia;
	}

	private int height(TreeNode node) {
		int left = 0;
		int right = 0;
		if (node.left != null) {
			left = height(node.left);
		}
		if (node.right != null) {
			right = height(node.right);
		}
		return Math.max(left, right) + 1;
	}
}
