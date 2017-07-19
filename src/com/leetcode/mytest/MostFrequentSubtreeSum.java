package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * 
 * SIZE = 10000; NUM = 10000; Iterator -- time consume:9532 Recursive -- time consume:79869
 *
 */
public class MostFrequentSubtreeSum {
	private static final int SIZE = 10000;
	private static final int NUM = 1000;

	public static void main(String[] args) {
		MostFrequentSubtreeSum mss = new MostFrequentSubtreeSum();
		List<TreeNode> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			int[] nums = CommonUtil.genereateArray(NUM);
			TreeNode root = CommonUtil.buildTree(nums);
			list.add(root);
		}
		System.out.println("start process...");

		long startTime0 = System.currentTimeMillis();
		for (TreeNode node : list) {
			mss.findFrequentTreeSumIterator(node);
		}
		long endTime0 = System.currentTimeMillis();
		// list.clear();
		// for (int i = 0; i < SIZE; i++) {
		// int[] nums = CommonUtil.genereateArray(NUM);
		// TreeNode root = CommonUtil.buildTree(nums);
		// list.add(root);
		// }
		// long startTime = System.currentTimeMillis();
		// int k = 0;
		// for (TreeNode node : list) {
		//// System.out.println("NoRecursive -- process " + (k++) + "th");
		// mss.findFrequentTreeSumNoRecursive(node);
		// }
		// long endTime = System.currentTimeMillis();
		// System.out.println("time consume:" + (endTime - startTime));

		list.clear();
		for (int i = 0; i < SIZE; i++) {
			int[] nums = CommonUtil.genereateArray(NUM);
			TreeNode root = CommonUtil.buildTree(nums);
			list.add(root);
		}
		long startTime1 = System.currentTimeMillis();
		// k = 0;
		for (TreeNode node : list) {
			// System.out.println("Recursive -- process " + (k++) + "th");
			mss.findFrequentTreeSum(node);
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("Iterator -- time consume:" + (endTime0 - startTime0));
		// System.out.println("NoRecursive -- time consume:" + (endTime - startTime));
		System.out.println("Recursive -- time consume:" + (endTime1 - startTime1));

	}

	@Test
	public void testFindFrequentTreeSumIterator() {
		MostFrequentSubtreeSum mss = new MostFrequentSubtreeSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(14);
		root.left.left = new TreeNode(1);
		int[] result = mss.findFrequentTreeSumIterator(root);
		for (int i : result) {
			System.out.print(i);
			System.out.print(",");
		}
	}

	public int[] findFrequentTreeSumIterator(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> stack1 = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			stack1.push(node);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		int max = 0;
		int size = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			int left = 0, right = 0;
			if (node.left != null) {
				left = node.left.val;
			}
			if (node.right != null) {
				right = node.right.val;
			}
			node.val += (left + right);
			if (map.get(node.val) == null) {
				map.put(node.val, 0);
			}
			int v = map.get(node.val) + 1;
			map.put(node.val, v);
			if (v > max) {
				max = v;
				size = 1;
			}
			else if (v == max) {
				size++;
			}
		}
		int[] result = new int[size];
		int i = 0;
		Set<Integer> keys = map.keySet();
		for (int key : keys) {
			if (map.get(key) == max) {
				result[i++] = key;
			}
		}
		return result;
	}

	public int[] findFrequentTreeSumNoRecursive(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		Map<TreeNode, Boolean> map = new HashMap<>();
		Map<Integer, Integer> freMap = new HashMap<>();
		int maxFreq = 0;
		List<Integer> result = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode t = stack.peek();
			if (map.get(t) == null || !map.get(t)) {
				TreeNode tmp = t.right;
				while (tmp != null) {
					stack.push(tmp);
					tmp = tmp.left;
				}
				map.put(t, true);
			}
			else {
				stack.pop();
				int left = 0, right = 0;
				if (t.left != null) {
					left = t.left.val;
				}
				if (t.right != null) {
					right = t.right.val;
				}
				t.val += (left + right);
				if (freMap.get(t.val) == null) {
					freMap.put(t.val, 0);
				}
				int v = freMap.get(t.val) + 1;
				freMap.put(t.val, v);
				if (v > maxFreq) {
					maxFreq = v;
				}
			}
		}
		Set<Integer> keys = freMap.keySet();
		for (int key : keys) {
			if (freMap.get(key) == maxFreq) {
				result.add(key);
			}
		}
		int idx = 0;
		int[] res = new int[result.size()];
		for (int i : result) {
			res[idx++] = i;
		}

		return res;
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Map<Integer, Integer> freqMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		int max = sumOfNode(root, freqMap, 0);
		Set<Integer> keys = freqMap.keySet();
		for (int key : keys) {
			if (freqMap.get(key) == max) {
				result.add(key);
			}
		}
		int i = 0;
		int[] res = new int[result.size()];
		for (int r : result) {
			res[i++] = r;
		}
		return res;
	}

	private int sumOfNode(TreeNode node, Map<Integer, Integer> map, int max) {
		int left = 0;
		int right = 0;
		if (node.left != null) {
			max = sumOfNode(node.left, map, max);
			left = node.left.val;
		}
		if (node.right != null) {
			max = sumOfNode(node.right, map, max);
			right = node.right.val;
		}
		node.val += (left + right);
		if (map.get(node.val) == null) {
			map.put(node.val, 0);
		}
		int v = map.get(node.val) + 1;
		map.put(node.val, v);
		if (v > max) {
			max = v;
		}
		return max;
	}
}
