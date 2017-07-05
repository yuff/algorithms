package com.leetcode.mytest;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists(lists, 0, lists.length - 1);
	}

	public ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex) {
		if (startIndex < 0 || endIndex > lists.length || startIndex > endIndex) {
			return null;
		}
		if (endIndex == startIndex) {
			return lists[endIndex];
		}
		else if (endIndex - startIndex == 1) {
			return mergeLists(lists[startIndex], lists[endIndex]);
		}
		else {
			int mid = (startIndex + endIndex) >> 1;
			ListNode l1 = mergeKLists(lists, startIndex, mid);
			ListNode l2 = mergeKLists(lists, mid + 1, endIndex);
			return mergeLists(l1, l2);
		}
	}

	private ListNode mergeLists(ListNode first, ListNode second) {
		ListNode result = null;
		if (first == null && second == null) {
			return null;
		} else if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}
		if (first.val <= second.val) {
			result = first;
			first = first.next;
		} else {
			result = second;
			second = second.next;
		}
		ListNode cur = result;
		while (first != null && second != null) {
			if (first.val <= second.val) {
				cur.next = first;
				first = first.next;
				cur = cur.next;
			} else {
				cur.next = second;
				second = second.next;
				cur = cur.next;
			}
		}
		if (first != null) {
			cur.next = first;
		}
		if (second != null) {
			cur.next = second;
		}
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
