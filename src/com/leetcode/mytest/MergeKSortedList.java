package com.leetcode.mytest;

import com.java8.util.ListNode;

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
		if (first.getVal() <= second.getVal()) {
			result = first;
			first = first.getNext();
		} else {
			result = second;
			second = second.getNext();
		}
		ListNode cur = result;
		while (first != null && second != null) {
			if (first.getVal() <= second.getVal()) {
				cur.setNext(first);
				first = first.getNext();
				cur = cur.getNext();
			} else {
				cur.setNext(second);
				second = second.getNext();
				cur = cur.getNext();
			}
		}
		if (first != null) {
			cur.setNext(first);
		}
		if (second != null) {
			cur.setNext(second);
		}
		return result;
	}
}
