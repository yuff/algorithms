package com.leetcode.mytest;

import com.java8.util.ListNode;
import com.java8.util.CommonUtil;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
		ListNode head = CommonUtil.buildListNode(new int[] {1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 8, 10});
		ListNode res = rd.deleteDuplicates(head);
		while (res != null) {
			System.out.print(res.val + ",");
			res = res.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			ListNode tmp = cur.next;
			if (cur.val == pre.val) {
				pre.next = tmp;
				cur = tmp;
			}
			else {
				pre = cur;
				cur = tmp;
			}
		}
		return head;
	}
}
