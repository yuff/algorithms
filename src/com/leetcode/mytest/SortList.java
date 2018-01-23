package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class SortList {
	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode node = sl.sortList(CommonUtil.buildListNode(new int[]{1,3,54,2,6,1,7,9,21,3}));
		CommonUtil.print(node);
	}
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        head = sortList(head);
        second = sortList(second);
        return merge(head, second);
    }

	private ListNode merge(ListNode first, ListNode second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		ListNode dummy = new ListNode(-1), cur = dummy;
		while (first != null && second != null) {
			if (first.val < second.val) {
				cur.next = first;
				first = first.next;
			} else {
				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
			cur.next = null;
		}
		if (first != null) {
			cur.next = first;
		}
		if (second != null) {
			cur.next = second;
		}
		return dummy.next;
	}

	private ListNode findMid(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
