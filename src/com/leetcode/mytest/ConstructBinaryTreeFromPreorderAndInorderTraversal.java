package com.leetcode.mytest;

import com.java8.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal cb = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode node = cb.buildTree(new int[]{-1}, new int[]{-1});
		System.out.println(node.val);
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		TreeNode root = new TreeNode(preorder[ps]);
		int id = findId(inorder, is, ie, preorder[ps]);
		int lcount = id - is, rcount = ie - id;
		if (lcount > 0) {
			root.left = buildTree(preorder, ps + 1, ps + lcount, inorder, is, id - 1);
		}
		if (rcount > 0) {
			root.right = buildTree(preorder, ps + lcount + 1, pe, inorder, id + 1, ie);
		}
		return root;
	}

	private int findId(int[] inorder, int start, int end, int num) {
		int result = start;
		for (int i = start; i <= end; i++) {
			if (inorder[i] == num) {
				result = i;
				break;
			}
		}
		return result;
	}
}
