package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NestedInteger {

	private Integer value;
	private List<NestedInteger> list;

	NestedInteger(Integer value, List<NestedInteger> list) {
		this.value = value;
		this.list = list;
	}

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger() {
		return value != null && list == null;
	}

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return value;
	}

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return list;
	}
}

public class FlattenNestedListIterator implements Iterator<Integer> {
	public static void main(String[] args) {
		NestedInteger n1 = new NestedInteger(1, null);
		NestedInteger n2 = new NestedInteger(2, null);
		List<NestedInteger> nl1 = new ArrayList<>();
		nl1.add(n1);
		nl1.add(n2);
		NestedInteger n3 = new NestedInteger(null, nl1);

		List<NestedInteger> n = new ArrayList<>();
		n.add(n3);
		n.add(n2);
		n.add(n3);

		FlattenNestedListIterator iter = new FlattenNestedListIterator(n);
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}

	}

	private List<Integer> nestedList;
	private int length;
	private int curIndex;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		this.nestedList = flattenList(nestedList);
		this.length = this.nestedList.size();
		this.curIndex = 0;
	}

	@Override
	public Integer next() {
		return nestedList.get(curIndex++);
	}

	@Override
	public boolean hasNext() {
		return curIndex < length;
	}

	private List<Integer> flattenList(List<NestedInteger> nestedList) {
		List<Integer> list = new ArrayList<>();
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				list.add(ni.getInteger());
			}
			else {
				list.addAll(flattenList(ni.getList()));
			}
		}
		return list;
	}
}
