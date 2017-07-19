package com.leetcode.mytest;

import java.util.Stack;

public class ConvertBSTTreeToGreaterTree {

	public static void main(String[] args) {
		ConvertBSTTreeToGreaterTree t = new ConvertBSTTreeToGreaterTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(-2);
		root.right.left = new TreeNode(3);
		TreeNode result = t.convertBST(root);
		System.out.println(result.val + "," + result.left.val + "," + result.right.val);
	}
	
	public TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node != null) {
			stack.push(node);
			node = node.right;
		}
		while(!stack.isEmpty()) {
			TreeNode t = stack.pop();
			if (t.right != null) {
				TreeNode tmp = t.right;
				while(tmp.left != null) {
					tmp = tmp.left;
				}
				t.val += tmp.val;
			}
			if (t.left != null) {
				TreeNode tmp = t.left;
				if (tmp.right == null) {
					t.left.val += t.val;
					stack.push(tmp);
				} else {
					while(tmp.right != null) {
						stack.push(tmp.right);
						tmp = tmp.right;
					}
					tmp.val += t.val;
				}

			}
		}
		return root;
	}
}
