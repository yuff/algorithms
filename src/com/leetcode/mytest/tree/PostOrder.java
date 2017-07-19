package com.leetcode.mytest.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.leetcode.mytest.CommonUtil;
import com.leetcode.mytest.TreeNode;

public class PostOrder {
	private static final int SIZE = 100;
	private static final int NUM = 100;

	public static void main(String[] args) {
		List<TreeNode> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			int[] nums = CommonUtil.genereateArray(NUM);
			TreeNode root = CommonUtil.buildTree(nums);
			list.add(root);
		}
		long start = System.currentTimeMillis();
		for (TreeNode root : list) {
			postOrder(root);
		}
		long end = System.currentTimeMillis();
		System.out.println("postOrder time consuming:" + (end - start));

		start = System.currentTimeMillis();
		for (TreeNode root : list) {
			postOrderNoRecursive(root);
		}
		end = System.currentTimeMillis();
		System.out.println("postOrderNoRecursive time consuming:" + (end - start));

		start = System.currentTimeMillis();
		for (TreeNode root : list) {
			postOrderIterator(root);
		}
		end = System.currentTimeMillis();
		System.out.println("postOrderIterator time consuming:" + (end - start));
		// List<Integer> result = postOrder(root);
		// List<Integer> result1 = postOrderNoRecursive(root);
		// List<Integer> result2 = postOrderIterator(root);
		// for (int i : result) {
		// System.out.print(i + ",");
		// }
		// System.out.println();
		// for (int i : result1) {
		// System.out.print(i + ",");
		// }
		// System.out.println();
		// for (int i : result2) {
		// System.out.print(i + ",");
		// }
	}

	public static List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.addAll(postOrder(root.getLeft()));
		result.addAll(postOrder(root.getRight()));
		result.add(root.getVal());
		return result;
	}

	public static List<Integer> postOrderIterator(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> stack1 = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			stack1.push(node);
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
		}
		while (!stack1.isEmpty()) {
			result.add(stack1.pop().getVal());
		}
		return result;
	}

	public static List<Integer> postOrderNoRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null) {
			stack.push(node);
			node = node.getLeft();
		}
		Map<TreeNode, Boolean> isVisitedMap = new HashMap<>();
		while (!stack.isEmpty()) {
			TreeNode tn = stack.peek();
			if (tn.getRight() == null) {
				stack.pop();
				result.add(tn.getVal());
			}
			else {
				if (isVisitedMap.get(tn) != null && isVisitedMap.get(tn)) {
					stack.pop();
					result.add(tn.getVal());
				}
				else {
					isVisitedMap.put(tn, true);
					node = tn.getRight();
					while (node != null) {
						stack.push(node);
						node = node.getLeft();
					}
				}

			}
		}
		return result;
	}
}
