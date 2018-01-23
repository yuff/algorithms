package com.leetcode.newround;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SecondMinimumNodeInBinaryTree {
	public static void main(String[] args) {
		SecondMinimumNodeInBinaryTree sm = new SecondMinimumNodeInBinaryTree();
		System.out.println(sm.findSecondMinimumValue(CommonUtil.buildTree(new int[] {1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3,
		                                                                             8, 4, 8, 3, 3, 1, 6})));
	}

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null || root.left == null) {
			return -1;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				return -1;
			}
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			if (left.val == right.val) {
				int v1 = findSecondMinimumValue(left);
				int v2 = findSecondMinimumValue(right);
				return v1 == -1 ? v2 : (v2 == -1 ? v1 : Math.min(v1, v2));
			}
			else if (left.val == cur.val) {
				int v1 = findSecondMinimumValue(left);
				return v1 == -1 ? right.val : Math.min(right.val, v1);
			}
			else {
				int v1 = findSecondMinimumValue(right);
				return v1 == -1 ? left.val : Math.min(left.val, v1);
			}
		}
		return -1;
	}
}
