package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class AverageOfBinaryTreeLevel637 {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<TreeNode> list = new ArrayList<>();
		list.add(root);

		while( list.size() != 0) {
			List<TreeNode> child = new ArrayList<>();
			double sum = 0;
			int size = list.size();
			for(TreeNode t: list) {
				if (t.left != null) {
					child.add(t.left);
				}
				if (t.right != null) {
					child.add(t.right);
				}
				sum += t.val;
			}
			result.add(sum/size);
			list = child;
		}
		return result;
	}
}
