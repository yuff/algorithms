package com.java8.util;

import java.util.Random;

public class CommonUtil {
	public static int[] genereateArray(int size) {
		int[] result = new int[size];
		int index = 0;
		Random random = new Random();
		while (index < size) {
			result[index++] = random.nextInt(1000);
		}
		return result;
	}

	public static TreeNode buildTree(int[] nums) {
		return buildTreeNode(nums, 0);
	}
	
	public static ListNode buildListNode(int[] nums) {
		ListNode node = new ListNode(nums[0]);
		int n = nums.length;
		ListNode cur = node;
		for(int i = 1; i < n; i++) {
			cur.setNext(new ListNode(nums[i]));
			cur = cur.getNext();
		}
		return node;
	}

	private static TreeNode buildTreeNode(int[] nums, int i) {
		TreeNode node = new TreeNode(nums[i]);
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int len = nums.length;
		if (left < len) {
			node.left = buildTreeNode(nums, left);
		}
		if (right < len) {
			node.right = buildTreeNode(nums, right);
		}
		return node;
	}

}
