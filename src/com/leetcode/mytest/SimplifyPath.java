package com.leetcode.mytest;

import java.util.*;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath("/home/"));
	}

	public String simplifyPath(String path) {
		if (path == null || path.isEmpty()) {
			return path;
		}
		LinkedList<String> stack = new LinkedList<>();
		String[] strs = path.split("/");
		for (String str : strs) {
			if ("..".equals(str)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			else if (!str.isEmpty() && !".".equals(str)) {
				stack.push(str);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("/");
		while (!stack.isEmpty()) {
			builder.append(stack.pollLast());
			builder.append("/");
		}
		String res = builder.toString();
		return res.substring(0, res.length() - 1);
	}
}
