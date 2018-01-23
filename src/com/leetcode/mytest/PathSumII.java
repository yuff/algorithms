package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class PathSumII {
	public static void main(String[] args) {
		PathSumII ps = new PathSumII();
		TreeNode root = CommonUtil.buildTree(new Integer[] {-2, null, -3});
		System.out.println(ps.pathSum(root, -5));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		Map<TreeNode, List<Integer>> map = new HashMap<>();
		stack.push(root);
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		map.put(root, list);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			List<Integer> tmp = map.get(node);
			if (node.left != null || node.right != null) {
				if (node.left != null) {
					TreeNode left = node.left;
					List<Integer> l = new ArrayList<>(tmp);
					l.add(left.val);
					stack.push(left);
					map.put(left, l);
				}
				if (node.right != null) {
					TreeNode right = node.right;
					List<Integer> r = new ArrayList<>(tmp);
					r.add(right.val);
					stack.push(right);
					map.put(right, r);
				}
			}
			else {
				if (sumOf(tmp) == sum) {
					result.add(tmp);
				}
			}

		}
		return result;
	}

	private int sumOf(List<Integer> tmp) {
		int sum = 0;
		for (int i : tmp) {
			sum += i;
		}
		return sum;
	}
}
