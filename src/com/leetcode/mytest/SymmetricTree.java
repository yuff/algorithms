package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		SymmetricTree st = new SymmetricTree();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 2, 3, 4, 4, 3});
		System.out.println(st.isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			if (!isSymmetric(list)) {
				return false;
			}
			else {
				List<TreeNode> tmp = new ArrayList<>();
				for (TreeNode node : list) {
					if (node.left != null) {
						tmp.add(node.left);
					}
					if (node.right != null) {
						tmp.add(node.right);
					}
				}
				list = tmp;
			}
		}
		return true;
	}

	private boolean isSymmetric(List<TreeNode> list) {
		int n = list.size();
		int start = 0, end = n - 1;
		boolean result = true;
		while (start <= end) {
			TreeNode a = list.get(start);
			TreeNode b = list.get(end);
			result = compare(a.left, b.right) && compare(a.right, b.left);
			if (!result) {
				return result;
			}
			start++;
			end--;
		}
		return true;
	}

	private boolean compare(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		else if (a != null && b != null && a.val == b.val) {
			return true;
		}
		else {
			return false;
		}
	}
}
