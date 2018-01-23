package com.leetcode.mytest;

import com.java8.util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal cb = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		TreeNode node = cb.buildTree(new int[]{-1}, new int[]{-1});
		System.out.println(node.val);
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null || postorder.length == 0 || postorder.length != inorder.length) {
			return null;
		}
		return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
		TreeNode root = new TreeNode(postorder[pe]);
		int id = findId(inorder, is, ie, postorder[pe]);
		int lcount = id - is, rcount = ie - id;
		if (lcount > 0) {
			root.left = buildTree(postorder, ps, ps + lcount - 1, inorder, is, id - 1);
		}
		if (rcount > 0) {
			root.right = buildTree(postorder, ps + lcount, pe - 1, inorder, id + 1, ie);
		}
		return root;
	}

	private int findId(int[] inorder, int start, int end, int num) {
		int result = -1;
		for (int i = start; i <= end; i++) {
			if (inorder[i] == num) {
				result = i;
				break;
			}
		}
		return result;
	}
}
