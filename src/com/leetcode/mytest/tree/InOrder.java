package com.leetcode.mytest.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.java8.util.TreeNode;

public class InOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(8));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(10));
		List<Integer> result = inOrder(root);
		 List<Integer> result1 = inOrderNoRecursive(root);
		for (int i : result) {
			System.out.print(i + ",");
		}
		System.out.println();
		for (int i : result1) {
			System.out.print(i + ",");
		}
	}

	public static List<Integer> inOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		if (root.getLeft() != null) {
			result.addAll(inOrder(root.getLeft()));
		}
		result.add(root.getVal());
		if (root.getRight() != null) {
			result.addAll(inOrder(root.getRight()));
		}
		return result;
	}

	public static List<Integer> inOrderNoRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();

		TreeNode node = root;
		while (node != null) {
			stack.add(node);
			node = node.getLeft();
		}
		while (!stack.isEmpty()) {
			TreeNode tn = stack.pop();
			result.add(tn.getVal());

			TreeNode tr = tn.getRight();
			while (tr != null) {
				stack.push(tr);
				tr = tr.getLeft();
			}
		}
		return result;
	}
}
