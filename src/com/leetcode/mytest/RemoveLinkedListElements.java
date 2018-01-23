package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class RemoveLinkedListElements {
	public static void main(String[] args) {
		RemoveLinkedListElements rl = new RemoveLinkedListElements();
		ListNode head = CommonUtil.buildListNode(new int[] {1, 2, 3, 6, 4, 5, 6, 3});
		ListNode result = rl.removeElements(head, 6);
		while (result != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}

	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode cur = head, pre = null;
		while (cur != null) {
			if (cur.val == val) {
				if (pre == null) {
					cur = cur.next;
					head = cur;
				}
				else {
					ListNode tmp = cur.next;
					pre.next = tmp;
					cur = tmp;
				}
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
