package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.java8.util.CommonUtil;

public class ShoppingOffer {
	public static void main(String[] args) {
		int a = 9;
		char c = (char)(a + '0');
		System.out.println(c);
		ShoppingOffer so = new ShoppingOffer();
		List<Integer> price = CommonUtil.convertToList(new int[] {2, 5});
		List<List<Integer>> special = new ArrayList<>();
		List<Integer> s1 = CommonUtil.convertToList(new int[] {3, 0, 5});
		List<Integer> s2 = CommonUtil.convertToList(new int[] {1, 2, 10});
		special.add(s1);
		special.add(s2);
		List<Integer> needs = CommonUtil.convertToList(new int[] {3, 2});
		System.out.println(so.shoppingOffers(price, special, needs));
	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		if (price == null || needs == null) {
			return 0;
		}
		int count = price.size();
		for (List<Integer> s : special) {
			calSaving(s, price);
		}
		removeNoMatchSpecial(special, needs);
		boolean fetchSpecial = special.size() > 0 ? true : false;
		Collections.sort(special, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o2.get(o2.size() - 1) - o1.get(o1.size() - 1);
			}

		});
		int result = 0;
		if (fetchSpecial) {
			int total = Integer.MAX_VALUE;
			for (List<Integer> s : special) {
				List<List<Integer>> specialCopy = new ArrayList<>(special);
				List<Integer> needsCopy = new ArrayList<>(needs);
				updateNeeds(s, needsCopy);
				int tmp = s.get(count) + shoppingOffers(price, specialCopy, needsCopy);
				if (tmp < total) {
					total = tmp;
				}
			}
			result = total;
		}
		else {
			for (int i = 0; i < count; i++) {
				if (needs.get(i) > 0) {
					result += (needs.get(i) * price.get(i));
				}
			}
		}
		return result;
	}

	private void updateNeeds(List<Integer> special, List<Integer> needs) {
		int size = needs.size();
		for (int i = 0; i < size; i++) {
			needs.set(i, needs.get(i) - special.get(i));
		}

	}

	private void removeNoMatchSpecial(List<List<Integer>> special, List<Integer> needs) {
		Iterator<List<Integer>> itr = special.iterator();
		while (itr.hasNext()) {
			List<Integer> tmp = itr.next();
			if (!isMatch(tmp, needs)) {
				itr.remove();
			}
		}

	}

	private boolean isMatch(List<Integer> special, List<Integer> needs) {
		if (special.get(special.size() - 1) < 0) {
			return false;
		}
		int size = needs.size();
		for (int i = 0; i < size; i++) {
			if (special.get(i) > needs.get(i)) {
				return false;
			}
		}
		return true;
	}

	private void calSaving(List<Integer> s, List<Integer> price) {
		int total = 0;
		int size = price.size();
		for (int i = 0; i < size; i++) {
			total += (price.get(i) * s.get(i));
		}
		s.add(total - s.get(size));
	}
}
