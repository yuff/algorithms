package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BSTIterator {
	public static void main(String[] args) {
		TreeNode root = CommonUtil.buildTree(new int[] {4, 2, 7, 1, 3, 5, 8});
		BSTIterator bst = new BSTIterator(root);
		while (bst.hasNext()) {
			System.out.print(bst.next() + ",");
		}
	}

	LinkedList<TreeNode> stack = new LinkedList<>();

	public BSTIterator(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode next = node.right;
		while (next != null) {
			stack.push(next);
			next = next.left;
		}
		return node.val;
	}
}
