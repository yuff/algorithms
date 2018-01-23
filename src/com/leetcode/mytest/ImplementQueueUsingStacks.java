package com.leetcode.mytest;

import java.util.LinkedList;

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		ImplementQueueUsingStacks iq = new ImplementQueueUsingStacks();
		iq.push(1);
		iq.push(2);
		System.out.println(iq.pop());
		System.out.println(iq.peek());
	}

	LinkedList<Integer> stack = new LinkedList<>();
	LinkedList<Integer> backupStack = new LinkedList<>();

	/** Initialize your data structure here. */
	public ImplementQueueUsingStacks() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		while (!stack.isEmpty()) {
			backupStack.push(stack.pop());
		}
		int result = backupStack.pop();
		while (!backupStack.isEmpty()) {
			stack.push(backupStack.pop());
		}
		return result;
	}

	/** Get the front element. */
	public int peek() {
		while (!stack.isEmpty()) {
			backupStack.push(stack.pop());
		}
		int result = backupStack.peek();
		while (!backupStack.isEmpty()) {
			stack.push(backupStack.pop());
		}
		return result;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
}
