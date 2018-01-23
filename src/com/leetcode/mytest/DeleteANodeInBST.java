package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class DeleteANodeInBST {
	public static void main(String[] args) {
		DeleteANodeInBST dnb = new DeleteANodeInBST();
		TreeNode root = CommonUtil.buildTree(new int[] {5, 2, 7, 1, 3, 6, 10});
		TreeNode result = dnb.deleteNode(root, 2);
		System.out.println(result.val);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		TreeNode parent = null, cur = root;
		boolean isLeft = false;
		while (cur != null) {
			if (cur.val == key) {
				break;
			}
			else if (key > cur.val) {
				parent = cur;
				cur = cur.right;
				isLeft = false;
			}
			else {
				parent = cur;
				cur = cur.left;
				isLeft = true;
			}
		}
		if (cur == null) {
			return root;
		}
		else {
			TreeNode node = combineChild(cur);
			if (parent != null) {
				if (isLeft) {
					parent.left = node;
				}
				else {
					parent.right = node;
				}
				return root;
			}
			else {
				return node;
			}
		}
	}

	private TreeNode combineChild(TreeNode node) {
		if (node.left == null) {
			return node.right;
		}
		else if (node.right == null) {
			return node.left;
		}
		else {
			TreeNode left = node.left, right = node.right, result = left;
			while (left.right != null) {
				left = left.right;
			}
			left.right = right;
			return result;
		}
	}
}
