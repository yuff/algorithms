package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII bt = new BinaryTreeLevelOrderTraversalII();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		System.out.println(bt.levelOrderBottom(root));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list = new LinkedList<>();
		if (root == null) {
			return list ;
		}
		List<TreeNode> level = new ArrayList<>();
		level.add(root);
		while (!level.isEmpty()) {
			List<TreeNode> tmp = new ArrayList<>();
			List<Integer> values = new ArrayList<>();
			for (TreeNode node : level) {
				values.add(node.val);
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			list.push(new ArrayList<>(values));
			level = tmp;
		}
		return list;
	}
}
