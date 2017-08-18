package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;

public class SmallestRange {
	public static void main(String[] args) {
		SmallestRange sr = new SmallestRange();
		List<List<Integer>> nums = new ArrayList<>();
		List<Integer> l0 = CommonUtil.convertToList(new int[] {1});
		List<Integer> l1 = CommonUtil.convertToList(new int[] {4, 10, 15, 24, 26});
		List<Integer> l2 = CommonUtil.convertToList(new int[] {0, 9, 12, 20});
		List<Integer> l3 = CommonUtil.convertToList(new int[] {5, 18, 22, 30});
		List<Integer> l4 = CommonUtil.convertToList(new int[] {6, 19, 21, 39,44});
		nums.add(l0);
//		nums.add(l2);
//		nums.add(l3);
//		nums.add(l4);
		int[] result = sr.smallestRange(nums);
		for (int i : result) {
			System.out.print(i + ",");
		}
	}

	public int[] smallestRange(List<List<Integer>> nums) {
		if (nums == null || nums.size() == 0) {
			return new int[2];
		}
		int k = nums.size();
		List<Entry> entries = mergeKLists(nums);
		int n = entries.size();
		int[] res = new int[3];
		res[0] = Integer.MAX_VALUE;
		// res[1] = entries.get(0).getKey();
		int start = 0, end = 0;
		int[] counts = new int[k];
		int count = 0;
		while (start < n && end < n) {
			Entry ee = entries.get(end);
			int tmp = ee.getValue();
			if (counts[tmp] == 0) {
				count++;
				counts[tmp] = 1;
				if (count == k) {
					int endValue = ee.getKey();
					while (start <= end && count == k) {
						Entry se = entries.get(start);
						int sIndex = se.getValue();
						counts[sIndex] -= 1;
						if (counts[sIndex] > 0) {
							start++;
						}
						else {
							int minus = endValue - entries.get(start).getKey() + 1;
							if (minus < res[0]) {
								res[0] = minus;
								res[1] = entries.get(start).getKey();
								res[2] = endValue;
							}
							start++;
							count--;
							end++;
						}
					}
				}
				else {
					end++;
				}
			}
			else {
				counts[tmp] += 1;
				end++;
			}
		}
		int[] result = new int[2];
		result[0] = res[1];
		result[1] = res[2];
		return result;
	}

	private List<Entry> mergeKLists(List<List<Integer>> nums) {
		List<List<Entry>> lists = new ArrayList<>();
		int n = nums.size();
		for (int i = 0; i < n; i++) {
			List<Integer> l = nums.get(i);
			List<Entry> entry = new ArrayList<>();
			for (int num : l) {
				entry.add(new Entry(num, i));
			}
			lists.add(entry);
		}
		return mergeLists(lists, 0, lists.size() - 1);
	}

	private List<Entry> mergeLists(List<List<Entry>> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		}
		int mid = (start + end) >> 1;
		List<Entry> r1 = mergeLists(lists, start, mid);
		List<Entry> r2 = mergeLists(lists, mid + 1, end);
		List<Entry> result = new ArrayList<>();
		int n1 = r1.size();
		int n2 = r2.size();
		int i = 0, j = 0;
		while (i < n1 && j < n2) {
			if (r1.get(i).getKey() < r2.get(j).getKey()) {
				result.add(r1.get(i++));
			}
			else {
				result.add(r2.get(j++));
			}
		}
		while (i < n1) {
			result.add(r1.get(i++));
		}
		while (j < n2) {
			result.add(r2.get(j++));
		}
		return result;
	}

	class Entry {
		int key;
		int value;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
