package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		BinaryTreeRightSideView brsv = new BinaryTreeRightSideView();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4});
		System.out.println(brsv.rightSideView(root));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		List<TreeNode> tier = new ArrayList<>();
		List<TreeNode> tmp = new ArrayList<>();
		tier.add(root);
		while (tier.size() > 0) {
			result.add(tier.get(tier.size() - 1).val);
			tmp.clear();
			for (TreeNode node : tier) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			tier.clear();
			tier.addAll(tmp);
			tmp.clear();
		}
		return result;
	}
}
