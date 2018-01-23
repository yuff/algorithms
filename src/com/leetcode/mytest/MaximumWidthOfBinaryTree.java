package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class MaximumWidthOfBinaryTree {
	public static void main(String[] args) {
		MaximumWidthOfBinaryTree mo = new MaximumWidthOfBinaryTree();
		TreeNode root = CommonUtil.buildTree(new Integer[] {1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null,
		                                                    null, 7});
		System.out.println(mo.widthOfBinaryTree(root));
	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int max = 0;
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			List<TreeNode> tmp = new ArrayList<>();
			int left = findMostLeft(list);
			int right = findMostRight(list);
			for (int i = left; i >= 0 && i < list.size() && i <= right; i++) {
				TreeNode node = list.get(i);
				if (node == null) {
					tmp.add(null);
					tmp.add(null);
				}
				else {
					tmp.add(node.left);
					tmp.add(node.right);
				}
			}
			int v = right - left + 1;
			if (v > max) {
				max = v;
			}
			list = tmp;
		}
		return max;
	}

	private int findMostLeft(List<TreeNode> list) {
		int i = 0;
		while (i < list.size() && list.get(i) == null) {
			i++;
		}
		return i;
	}

	private int findMostRight(List<TreeNode> list) {
		int i = list.size() - 1;;
		while (i >= 0 && list.get(i) == null) {
			i--;
		}
		return i;
	}
}
