package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class PathSumIII {
	public static void main(String[] args) {
		PathSumIII ps = new PathSumIII();
		TreeNode root = CommonUtil.buildTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
		System.out.println(ps.pathSum(root , 8));
	}
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		Map<TreeNode, List<Integer>> map = new HashMap<>();
		map.put(root, new ArrayList<Integer>());
		map.get(root).add(root.val);
		if (root.val == sum) {
			result++;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			List<Integer> nList = map.get(node);
			if (node.left != null) {
				int val = node.left.val;
				List<Integer> left = new ArrayList<>();
				left.add(val);
				if (val == sum) {
					result++;
				}
				for (int i : nList) {
					left.add(i + val);
					if (i + val == sum) {
						result++;
					}
				}
				map.put(node.left, left);
				stack.push(node.left);
			}
			if (node.right != null) {
				int val = node.right.val;
				List<Integer> right = new ArrayList<>();
				right.add(val);
				if (val == sum) {
					result++;
				}
				for (int i : nList) {
					right.add(i + val);
					if (i + val == sum) {
						result++;
					}
				}
				map.put(node.right, right);
				stack.push(node.right);
			}
		}
		return result;
	}

}
