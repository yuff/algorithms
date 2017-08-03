package com.leetcode.mytest.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.java8.util.TreeNode;

public class PreOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(8));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(10));
		List<Integer> result = preOrder(root);
		List<Integer> result1 = preOrderNoRecursive(root);
		for(int i: result) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(int i: result1) {
			System.out.print(i + ",");
		}
	}

	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.add(root.getVal());
		result.addAll(preOrder(root.getLeft()));
		result.addAll(preOrder(root.getRight()));
		return result;
	}
	
	public static List<Integer> preOrderNoRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.getVal());
			if (node.getRight() != null) {
				stack.add(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.add(node.getLeft());
			}
		}
		return result;
	}
}
