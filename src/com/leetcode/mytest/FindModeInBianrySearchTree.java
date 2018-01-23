package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class FindModeInBianrySearchTree {
	public static void main(String[] args) {
		FindModeInBianrySearchTree fm = new FindModeInBianrySearchTree();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2});
		int[] result = fm.findMode(root);
		for (int i : result) {
			System.out.print(i + ",");
		}
	}

	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		stack.push(root);
		TreeNode tmp = root.left;
		while (tmp != null) {
			stack.push(tmp);
			tmp = tmp.left;
		}
		int max = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (map.get(node.val) == null) {
				map.put(node.val, 0);
			}

			map.put(node.val, map.get(node.val) + 1);
			if (map.get(node.val) > max) {
				max = map.get(node.val);
				list.clear();
				list.add(node.val);
			}
			else if (map.get(node.val) == max) {
				list.add(node.val);
			}

			if (node.right != null) {
				stack.push(node.right);
				tmp = node.right.left;
				while (tmp != null) {
					stack.push(tmp);
					tmp = tmp.left;
				}
			}
		}
		int[] result = new int[list.size()];
		int i = 0;
		for (int num : list) {
			result[i++] = num;
		}
		return result;
	}
}
