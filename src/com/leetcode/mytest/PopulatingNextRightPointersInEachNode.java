package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.TreeLinkNode;

//class TreeLinkNode {
//	int val;
//	TreeLinkNode left, right, next;
//
//	TreeLinkNode(int x) {
//		val = x;
//	}
//}

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		List<TreeLinkNode> list = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			TreeLinkNode pre = list.get(0);
			List<TreeLinkNode> tmp = new ArrayList<>();
			if (pre.left != null) {
				tmp.add(pre.left);
			}
			if (pre.right != null) {
				tmp.add(pre.right);
			}
			int n = list.size();
			for (int i = 1; i < n; i++) {
				TreeLinkNode t = list.get(i);
				pre.next = t;
				pre = pre.next;
				if (pre.left != null) {
					tmp.add(pre.left);
				}
				if (pre.right != null) {
					tmp.add(pre.right);
				}
			}
			list = tmp;
		}
	}
}
