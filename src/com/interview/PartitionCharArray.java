package com.interview;

import java.util.*;

public class PartitionCharArray {

	public static void main(String[] args) {
		PartitionCharArray pca = new PartitionCharArray();
		System.out.println(pca.partitionCharArray(new char[] {'a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j'}));
		System.out.println(pca.partitionCharArray(new char[] {'a', 'b', 'c', 'a'}));
		System.out.println(pca.partitionCharArray(new char[] {'a', 'b', 'e', 'c', 'a', 'e', 'h'}));
		System.out.println(pca.partitionCharArray(new char[] {'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e',
		                                                      'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l',
		                                                      'i', 'j'}));
	}

	public List<Integer> partitionCharArray(char[] arr) {
		List<Integer> result = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return result;
		}
		int n = arr.length;
		Map<Character, int[]> index = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (index.get(arr[i]) == null) {
				index.put(arr[i], new int[] {i, i});
			}
			else {
				int[] id = index.get(arr[i]);
				id[1] = i;
			}
		}
		List<int[]> list = new ArrayList<>(index.values());
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int size = list.size();
		int[] range = list.get(0);
		for (int i = 1; i < size; i++) {
			int[] cur = list.get(i);
			if (cur[0] < range[1]) {
				range[1] = Math.max(cur[1], range[1]);
			}
			else {
				result.add(range[1] - range[0] + 1);
				range = cur;
			}
		}
		result.add(range[1] - range[0] + 1);
		return result;
	}
}
