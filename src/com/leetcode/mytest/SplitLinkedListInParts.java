package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class SplitLinkedListInParts {
	public static void main(String[] args) {
		SplitLinkedListInParts sl = new SplitLinkedListInParts();
		ListNode root = CommonUtil.buildListNode(new int[] {1, 2, 3, 4, 5, 6, 7});
		ListNode[] r = sl.splitListToParts(root, 5);
		for(ListNode node: r) {
			CommonUtil.print(node);
		}
	}

	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode cur = root, pre = null;;
		ListNode[] result = new ListNode[k];
		int n = countListNode(root);
		int count = n / k, m = n % k;
		int i = 0;
		while (k > 0) {
			result[i++] = cur;
			int num = m <= 0 ? count : count + 1;
			while (cur != null && num > 0) {
				pre = cur;
				cur = cur.next;
				num--;
			}
			if (pre != null) {
				pre.next = null;
			}
			m--;
			k--;
		}
		return result;
	}

	private int countListNode(ListNode root) {
		int n = 0;
		while (root != null) {
			n++;
			root = root.next;
		}
		return n;
	}
}
