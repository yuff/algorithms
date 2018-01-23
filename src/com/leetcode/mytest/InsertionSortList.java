package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class InsertionSortList {
	public static void main(String[] args) {
		InsertionSortList is = new InsertionSortList();
		ListNode head = CommonUtil.buildListNode(new int[]{3,2,1,4,5,8,6,9});
		ListNode r = is.insertionSortList(head );
		while (r != null) {
			System.out.print(r.val + ",");
			r = r.next;
		}
	}
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            ListNode p = head, pp = null, next = cur.next;
            while (p != cur && p.val <= cur.val) {
                pp = p;
                p = p.next;
            }
            if (pp == null) {
                cur.next = p;
                head = cur;
            } else if (pp == pre) {
            	pre = cur;
            	cur = next;
            } else{
                pp.next = cur;
                cur.next = p;
            }
            pre.next = next;
            cur = next;
        }
        return head;
    }
}
