package com.leetcode.mytest.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.leetcode.mytest.TreeNode;

public class PostOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(8));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(10));
		List<Integer> result = postOrder(root);
		List<Integer> result1 = postOrderNoRecursive(root);
		for (int i : result) {
			System.out.print(i + ",");
		}
		System.out.println();
		for (int i : result1) {
			System.out.print(i + ",");
		}
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
	
	public static List<Integer> postOrderNoRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node != null) {
			stack.push(node);
			node = node.getLeft();
		}
		Map<TreeNode, Boolean> isVisitedMap = new HashMap<>();
		while(!stack.isEmpty()) {
			TreeNode tn = stack.peek();
			if (tn.getRight() == null) {
				stack.pop();
				result.add(tn.getVal());
			} else {
				if (isVisitedMap.get(tn) != null && isVisitedMap.get(tn)) {
					stack.pop();
					result.add(tn.getVal());
				} else {
					isVisitedMap.put(tn, true);
					node = tn.getRight();
					while(node != null) {
						stack.push(node); 
						node = node.getLeft();
					}
				}

			} 
		}
		return result;
	}
}
