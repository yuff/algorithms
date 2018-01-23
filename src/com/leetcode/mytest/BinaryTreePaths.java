package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BinaryTreePaths {
	public static void main(String[] args) {
		BinaryTreePaths btp = new BinaryTreePaths();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5});
		System.out.println(btp.binaryTreePaths(root));
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Map<TreeNode, StringBuilder> map = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		builder.append(root.val);
		map.put(root, builder);
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			String s = map.get(node).toString();
			if (node.left == null && node.right == null) {
				result.add(s);
			}
			else {
				if (node.left != null) {
					processNode(map, stack, s, node.left);
				}
				if (node.right != null) {
					processNode(map, stack, s, node.right);
				}
			}
		}
		return result;
	}

	public void processNode(Map<TreeNode, StringBuilder> map, LinkedList<TreeNode> stack, String s, TreeNode tmp) {
		StringBuilder b = new StringBuilder(s);
		b.append("->");
		b.append(tmp.val);
		stack.push(tmp);
		map.put(tmp, b);
	}
}
