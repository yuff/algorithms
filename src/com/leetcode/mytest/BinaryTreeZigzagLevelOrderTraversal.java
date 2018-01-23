package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
		System.out.println(bt.zigzagLevelOrder(root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> result = new ArrayList<>();
		boolean reverse = false;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			List<Integer> r = new ArrayList<>();
			LinkedList<TreeNode> tmp = new LinkedList<>();
			while (!list.isEmpty()) {
				TreeNode node = list.pop();
				r.add(node.val);
				if (reverse) {
					if (node.right != null) {
						tmp.push(node.right);
					}
					if (node.left != null) {
						tmp.push(node.left);
					}
				}
				else {
					if (node.left != null) {
						tmp.push(node.left);
					}
					if (node.right != null) {
						tmp.push(node.right);
					}
				}
			}
			reverse = !reverse;
			list = tmp;
			result.add(r);
		}
		return result;
	}
}
