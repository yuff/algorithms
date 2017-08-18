package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BulbSwitcher2 {

	public static void main(String[] args) {
		BulbSwitcher2 bs = new BulbSwitcher2();
		System.out.println(bs.bulbSwitch(999999));
	}

	public int bulbSwitch(int n) {
		if (n == 0) {
			return 0;
		}
		int count = 1;
		List<Integer> primes = new ArrayList<>();
		boolean[] processed = new boolean[n + 1];
		processed[1] = true;
		Map<Integer, Set<Integer>> divisors = new HashMap<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				primes.add(i);
				processed[i] = true;
				divisors.put(i, new HashSet<Integer>());
				divisors.get(i).add(1);
				divisors.get(i).add(i);
			}
		}
		for (int i = 2; i <= n; i++) {
			if (!processed[i]) {
				int c = countDivisors(i, divisors, primes);
				if (c % 2 != 0) {
					count++;
				}
				processed[i] = true;
			}
		}
		return count;
	}

	private int countDivisors(int num, Map<Integer, Set<Integer>> divisors, List<Integer> primes) {
		for (int p : primes) {
			if (num % p == 0) {
				int d = num / p;
				Set<Integer> divisor = divisors.get(d);
				Set<Integer> r = new HashSet<>();
				r.addAll(divisor);
				for (int i : divisor) {
					r.add(i * p);
				}
				divisors.put(num, r);
				return r.size();
			}
		}
		return 0;
	}

	private boolean isPrime(int n) {
		int size = (int) Math.sqrt(n);
		boolean prime = true;
		for (int i = 2; i <= size; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

}
