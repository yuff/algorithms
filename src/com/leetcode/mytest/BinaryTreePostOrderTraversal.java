package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BinaryTreePostOrderTraversal {
	public static void main(String[] args) {
		BinaryTreePostOrderTraversal btp = new BinaryTreePostOrderTraversal();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5, 6});
		System.out.println(btp.postorderTraversal(root));
		System.out.println(btp.postorderTraversalIterative(root));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		result.addAll(postorderTraversal(root.left));
		result.addAll(postorderTraversal(root.right));
		result.add(root.val);
		return result;
	}

	public List<Integer> postorderTraversalIterative(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<TreeNode> stack1 = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			if (t.left != null) {
				stack.push(t.left);
			}
			if (t.right != null) {
				stack.push(t.right);
			}
			stack1.push(t);
		}
		while (!stack1.isEmpty()) {
			TreeNode t = stack1.pop();
			result.add(t.val);
		}
		return result;
	}
}
