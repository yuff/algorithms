package com.leetcode.newround;

import java.util.LinkedList;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		RecoverBinarySearchTree rb = new RecoverBinarySearchTree();
		TreeNode root = CommonUtil.buildTree(new Integer[] {2, null, 1});
		rb.recoverTree(root);
		CommonUtil.print(root);
	}

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		TreeNode first = null, second = null, pre = null;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (pre != null) {
				if (node.val < pre.val) {
					if (first == null) {
						first = pre;
						second = node;
					}
					else {
						second = node;
						break;
					}
				}
			}
			cur = node.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			pre = node;
		}
		if (first != null && second != null) {
			int value = first.val;
			first.val = second.val;
			second.val = value;
		}
	}
}
