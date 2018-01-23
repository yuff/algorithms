package com.java8.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CommonUtil {
	public static List<Integer> convertToList(int[] array) {
		List<Integer> r = new ArrayList<>();
		for (int i : array) {
			r.add(i);
		}
		return r;
	}

	public static int[] genereateArray(int size) {
		int[] result = new int[size];
		int index = 0;
		Random random = new Random();
		while (index < size) {
			result[index++] = random.nextInt(1000);
		}
		return result;
	}

	public static TreeNode buildTree(Integer[] nums) {
		return buildTreeNode(nums, 0);
	}

	public static TreeNode buildTree(int[] nums) {
		return buildTreeNode(nums, 0);
	}

	public static ListNode buildListNode(int[] nums) {
		ListNode node = new ListNode(nums[0]);
		int n = nums.length;
		ListNode cur = node;
		for (int i = 1; i < n; i++) {
			cur.setNext(new ListNode(nums[i]));
			cur = cur.getNext();
		}
		return node;
	}

	private static TreeNode buildTreeNode(Integer[] nums, int i) {
		if (nums[i] == null) {
			return null;
		}
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

	public static com.java8.util.TreeLinkNode buildTreeLink(int[] nums) {
		return buildTreeLinkNode(nums, 0);
	}

	private static TreeLinkNode buildTreeLinkNode(int[] nums, int i) {
		TreeLinkNode node = new TreeLinkNode(nums[i]);
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int len = nums.length;
		if (left < len) {
			node.left = buildTreeLinkNode(nums, left);
		}
		if (right < len) {
			node.right = buildTreeLinkNode(nums, right);
		}
		return node;
	}

	public static String print(ListNode head) {
		if (head == null) {
			System.out.println("");
			return "";
		}
		StringBuilder builder = new StringBuilder();
		while (head != null) {
			builder.append(head.val);
			builder.append(",");
			head = head.next;
		}
		String result =  new String(builder.toString().substring(0, builder.toString().length() - 1));
		System.out.println(result);
		return result;
	}

	public static String print(TreeNode r) {
		StringBuilder builder = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(r);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {				
				builder.append(node.val);
				queue.add(node.left);
				queue.add(node.right);
			} else {
				builder.append("null");
			}
			builder.append(",");
		}
		String result =  new String(builder.toString().substring(0, builder.toString().length() - 1));
		System.out.println(result);
		return result;
		
	}

	public static String print(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "empty array!!";
		}
		StringBuilder builder = new StringBuilder();
		for(int i: nums) {
			builder.append(i);
			builder.append(",");
		}
		String result =  new String(builder.toString().substring(0, builder.toString().length() - 1));
		System.out.println(result);
		return result;		
	}
	public static String print(char[] chars) {
		StringBuilder builder = new StringBuilder();
		for(char i: chars) {
			builder.append(i);
			builder.append(",");
		}
		String result =  new String(builder.toString().substring(0, builder.toString().length() - 1));
		System.out.println(result);
		return result;		
	}

	public static List<int[]> buildList(String s) {
		List<int[]> result = new ArrayList<>();
		String[] strs = s.split("\\],\\[");
		for(String str: strs) {
			String newStr = str.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] nums = newStr.split(",");
			int[] tmp = new int[nums.length];
			int i = 0;
			for(String num: nums) {
				tmp[i++] = Integer.valueOf(num);
			}
			result.add(tmp);
		}
		return result;
	}
	
	public static List<String> buildList(String[] arr) {
		List<String> result = new ArrayList<>();
		for(String s: arr) {
			result.add(s);
		}
		return result;
	}

	public static String print(double[] arr) {
		StringBuilder builder = new StringBuilder();
		for(double d: arr) {
			builder.append(d);
			builder.append(",");
		}
		String result =  new String(builder.toString().substring(0, builder.toString().length() - 1));
		System.out.println(result);
		return result;	
		
	}

}
