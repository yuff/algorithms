package com.leetcode.newround;

import java.util.LinkedList;

import com.java8.util.CommonUtil;

public class AsteroidCollision {
	public static void main(String[] args) {
		AsteroidCollision ac = new AsteroidCollision();
		 CommonUtil.print(ac.asteroidCollision(new int[]{-2, -1, 1, 2}));
		CommonUtil.print(ac.asteroidCollision(new int[] {10, 2, -5}));
		CommonUtil.print(ac.asteroidCollision(new int[] {5, 10, -5}));
		CommonUtil.print(ac.asteroidCollision(new int[] {5, -5}));
		CommonUtil.print(ac.asteroidCollision(new int[] {-2, -2, 1, -2}));
	}

	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) {
			return asteroids;
		}
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < asteroids.length; i++) {
			int a = asteroids[i];
			if (a > 0) {
				stack.push(a);
			}
			else if (a < 0) {
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(a);
				}
				else {

					while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						stack.push(a);
					}
					else if (stack.peek() < 0) {
						stack.push(a);
					}
					else if (stack.peek() == -a) {
						stack.pop();
					}
				}
			}
		}
		int[] result = new int[stack.size()];
		int id = stack.size() - 1;
		while (!stack.isEmpty()) {
			result[id--] = stack.pop();
		}
		return result;
	}
}
