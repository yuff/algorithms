package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII pn = new PopulatingNextRightPointersInEachNodeII();
		TreeLinkNode root = CommonUtil.buildTreeLink(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		pn.connect(root);
		System.out.println(root.left.next.val);
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode cur = root, left = null, right = null, first = null;
		while (cur != null) {
			boolean hasLeftProcess = false;
			while (cur != null) {
				while (cur != null && left == null) {
					left = cur.left == null ? cur.right : cur.left;
					if (cur.left == null || cur.right == null) {
						cur = cur.next;
						hasLeftProcess = false;
					} else {
						hasLeftProcess = true;
					}
				}
				if (first == null) {
					first = left;
				}
				while (cur != null && right == null) {
					if (hasLeftProcess) {
						if (cur.right == null) {
							cur = cur.next;
							hasLeftProcess = false;
						} else {							
							right = cur.right;
							cur = cur.next;
							hasLeftProcess = false;
						}
					} else {						
						right = cur.left == null ? cur.right : cur.left;
						if (cur.left == null || cur.right == null) {							
							cur = cur.next;
							hasLeftProcess = false;
						} else {
							hasLeftProcess = true;
						}
					}
				}
				if (left != null) {
					left.next = right;
					left = right;
					right = null;
				}
			}
			cur = first;
			left = null;
			right = null;
			first = null;
		}
	}
}
