package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		ValidateBinarySearchTree vb = new ValidateBinarySearchTree();
		TreeNode root =CommonUtil.buildTree(new int[]{3,1,4});
		TreeNode root1 =CommonUtil.buildTree(new Integer[]{10,5,15,null,null,6,20});
		System.out.println(vb.isValidBST(root));
		System.out.println(vb.isValidBST(root1));
	}
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean result = true;
		if (root.left != null) {
			TreeNode right = root.left;
			while (right.right != null) {
				right = right.right;
			}
			result &= right.val < root.val && isValidBST(root.left);
		}
		if (root.right != null) {
			TreeNode left = root.right;
			while (left.left != null) {
				left = left.left;
			}
			result &= left.val > root.val && isValidBST(root.right);
		}
		return result;
	}
	
}
