package com.datastructure;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode head = CommonUtil.buildListNode(new int[] {3, 4, 6, 7, 8});
		CommonUtil.print(rl.reverseLinkedList(head));
	}

	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null, cur = head, next = head.next;
		while (cur != null) {
			cur.next = pre;
			pre = cur;
			ListNode tmp = next == null ? null : next.next;
			cur = next;
			next = tmp;
		}
		return pre;
	}
}
