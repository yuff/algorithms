package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.java8.util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
	public static void main(String[] args) {
		LowestCommonAncestorOfABinarySearchTree lc = new LowestCommonAncestorOfABinarySearchTree();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode leftleft = new TreeNode(11);
		TreeNode right = new TreeNode(3);
		left.left = leftleft;
		root.left = left;
		root.right = right;
		TreeNode result = lc.lowestCommonAncestor(root, leftleft, right);
		System.out.println(result.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p == null && q != null) {
			return q;
		}
		if (q == null && p != null) {
			return p;
		}
		List<TreeNode> list = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (isAncestor(node, p) && isAncestor(node, q)) {
				list.add(node);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		if (!list.isEmpty()) {
			return list.get(list.size() - 1);
		}
		else {
			return null;
		}
	}

	private boolean isAncestor(TreeNode node, TreeNode p) {
		if (node == p) {
			return true;
		}
		boolean left = false;
		boolean right = false;
		if (node.left != null) {
			left = isAncestor(node.left, p);
		}
		if (node.right != null) {
			right = isAncestor(node.right, p);
		}
		return left || right;
	}
}
