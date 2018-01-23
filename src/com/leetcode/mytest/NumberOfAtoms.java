package com.leetcode.mytest;

import java.util.*;

public class NumberOfAtoms {
	public static void main(String[] args) {
		NumberOfAtoms noa = new NumberOfAtoms();
		System.out.println(noa.countOfAtoms("H2O"));
	}
	public String countOfAtoms(String formula) {
		if (formula == null || formula.isEmpty()) {
			return formula;
		}
		Map<String, Integer> map = parse(formula);
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		StringBuilder b = new StringBuilder();
		for (String s : list) {
			b.append(s);
			if (map.get(s) > 1) {
				b.append(map.get(s));
			}
		}
		return b.toString();
	}

	private Map<String, Integer> parse(String s) {
		Map<String, Integer> map = new HashMap<>();
		int n = s.length(), i = 0;
		char[] arr = s.toCharArray();
		while (i < n) {
			char c = arr[i];
			if (c == '(') {
				int eId = findParenthesisEndId(arr, i);
				Map<String, Integer> tMap = parse(new String(arr, i + 1, eId - i - 1));
				int[] multiInfo = parseMultiInfo(arr, eId + 1);
				i = multiInfo[0];
				multiMap(tMap, multiInfo[1]);
				mergeMap(map, tMap);
			}
			else if (c >= 'A' && c <= 'Z') {
				int aId = findAtomEndId(arr, i);
				String atom = new String(arr, i, aId - i);

				int[] multiInfo = parseMultiInfo(arr, aId);
				i = multiInfo[0];
				if (map.get(atom) == null) {
					map.put(atom, multiInfo[1]);
				}
				else {
					map.put(atom, map.get(atom) + multiInfo[1]);
				}
			}
		}
		return map;
	}

	private int findAtomEndId(char[] arr, int start) {
		int n = arr.length, i = start + 1;
		while (i < n) {
			char c= arr[i];
			if (c >= 'a' && c <= 'z') {
				i++;
			} else {
				break;
			}
		}
		return i;
	}

	private void mergeMap(Map<String, Integer> map, Map<String, Integer> tMap) {
		for(String s: tMap.keySet()) {
			if (map.get(s) == null) {
				map.put(s, tMap.get(s));
			} else {
				int count = map.get(s) + tMap.get(s);
				map.put(s, count);
			}
		}
		
	}

	private void multiMap(Map<String, Integer> map, int multi) {
		for(String s: map.keySet()) {
			int initial = map.get(s);
			map.put(s, initial * multi);
		}
	}

	private int[] parseMultiInfo(char[] arr, int start) {
		int[] result = new int[2];
		int n = arr.length;
		int count = 0;
		while (start < n) {
			char next = arr[start];
			if (next >= '0' && next <= '9') {
				count = count * 10 + (next - '0');
				start++;
			} else {
				break;
			}
		}
		result[0] = start;
		result[1] = count == 0? 1 : count;
		return result;
	}

	private int findParenthesisEndId(char[] arr, int start) {
		int n = arr.length, count = 1, i = start + 1;
		while (i < n) {
			if (arr[i] == ')') {
				count--;
			}
			else if (arr[i] == '(') {
				count++;
			}
			if (count == 0) {
				break;
			}
			i++;
		}
		return i;
	}
}
