package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class TrimABinarySearchTree {
	public static void main(String[] args) {
		TrimABinarySearchTree ta = new TrimABinarySearchTree();
		TreeNode root = CommonUtil.buildTree(new Integer[] {45, 30, 46, 10, 36, null, 49, 8, 24, 34, 42, 48, null, 4, 9,
		                                                    14, 25, 31, 35, 41, 43, 47, null, 0, 6, null, null, 11, 20,
		                                                    null, 28, null, 33, null, null, 37, null, null, 44, null,
		                                                    null, null, 1, 5, 7, null, 12, 19, 21, 26, 29, 32, null,
		                                                    null, 38, null, null, null, 3, null, null, null, null, null,
		                                                    13, 18, null, null, 22, null, 27, null, null, null, null,
		                                                    null, 39, 2, null, null, null, 15, null, null, 23, null,
		                                                    null, null, 40, null, null, null, 16, null, null, null,
		                                                    null, null, 17});
		TreeNode r = ta.trimBST(root, 32, 44);
		CommonUtil.print(r);
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return root;
		}
		TreeNode result = root;
		while (result != null && (result.val >R || result.val < L)) {			
			while (result != null && result.val < L) {
				result = result.right;
			}
			while (result != null && result.val > R) {
				result = result.left;
			}
		}
		CommonUtil.print(result);
		if (result == null) {
			return result;
		}
		trim(result, result.left, L, R);
		trim(result, result.right, L, R);
		return result;
	}

	private void trim(TreeNode p, TreeNode c, int l, int r) {
		if (c == null) {
			return;
		}
		if (c.val < l) {
			p.left = c.right;
			trim(p, p.left, l, r);
		}
		else if (c.val >= l && c.val <= r) {
			trim(c, c.left, l, r);
			trim(c, c.right, l, r);
		}
		else {
			p.right = c.left;
			trim(p, p.right, l, r);
		}
	}
}
