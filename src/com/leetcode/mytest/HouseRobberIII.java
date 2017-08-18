package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class HouseRobberIII {
	public static void main(String[] args) {
		HouseRobberIII hr = new HouseRobberIII();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 4, 3, 2});
		System.out.println(hr.rob(root));
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(4);
		System.out.println(hr.rob(node));
	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<TreeNode> list = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			list.add(node);
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
		List<TreeNode> robed = new ArrayList<>();
		int[] result = new int[1];
		maxRob(list, robed, 0, 0, result);
		return result[0];
	}

	private void maxRob(List<TreeNode> list, List<TreeNode> robbed, int currentValue, int startIndex,
	                    int[] result) {
		int n = list.size();
		if (currentValue > result[0]) {
			result[0] = currentValue;
		}
		if (startIndex == n) {
			return;
		}
		for (int i = startIndex; i < n; i++) {
			if (canRob(robbed, list.get(i))) {
				robbed.add(list.get(i));
				maxRob(list, robbed, currentValue + list.get(i).val, i + 1, result);
				robbed.remove(robbed.size() - 1);
			} else if (i == n - 1) {
				return;
			}
		}
	}

	private boolean canRob(List<TreeNode> ids, TreeNode node) {
		if (ids.isEmpty()) {
			return true;
		}
		else {
			boolean result = true;
			for (TreeNode id : ids) {
				if (node.equals(id) || node.equals(id.left) || node.equals(id.right)) {
					result = false;
					break;
				}
			}
			return result;
		}
	}
}
