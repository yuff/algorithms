package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class FindDuplicateSubTrees {
	public static void main(String[] args) {
		FindDuplicateSubTrees fd = new FindDuplicateSubTrees();
		TreeNode root = CommonUtil.buildTree(new Integer[] {-9,8,null,7,9,null,null,8,6,null,8});
		List<TreeNode> result = fd.findDuplicateSubtrees(root);
		for(TreeNode node: result) {
			System.out.println(node.val);
		}
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) {
			return new ArrayList<TreeNode>();
		}
		List<TreeNode> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		compare(result, map, root);
		return result;
	}

	private String compare(List<TreeNode> result, Map<String, Integer> map, TreeNode cur) {
		if (cur == null) {
			return "#";
		} else {
			String s =  cur.val + compare(result, map, cur.left) + compare(result, map, cur.right);
			if (map.get(s) == null) {
				map.put(s, 1);
			} else if (map.get(s) == 1) {
				result.add(cur);
				map.put(s, 2);
			}
			return s;
		}
	}
}
