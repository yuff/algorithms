package com.datastructure;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[]{3,4,2,5,6,8,1,9,18,12,22,16,19,9};
		int[] result = new MergeSort().mergeSort(array);
		for(int i: result) {
			System.out.print(i);
			System.out.print(",");
		}
	}
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		return mergeSort(array, 0, array.length - 1);
	}

	private int[] mergeSort(int[] array, int start, int end) {
		if (end < start) {
			throw new RuntimeException("error");
		}
		else if (end > start) {
			int mid = (start + end) >> 1;
			int[] r1 = mergeSort(array, start, mid);
			int[] r2 = mergeSort(array, mid + 1, end);
			return merge(r1, r2);
		}
		else {
			return new int[] {array[start]};
		}
	}

	private int[] merge(int[] r1, int[] r2) {
		int r1Size = r1.length;
		int r2Size = r2.length;
		int rSize = r1Size + r2Size;
		int[] result = new int[rSize];
		int i = 0, j = 0, k = 0;
		while (i < r1Size && j < r2Size) {
			if (r1[i] <= r2[j]) {
				result[k++] = r1[i];
				i++;
			}
			else {
				result[k++] = r2[j];
				j++;
			}
		}
		if (i < r1Size) {
			while (i < r1Size) {
				result[k++] = r1[i++];
			}
		}
		else {
			while (j < r2Size) {
				result[k++] = r2[j++];
			}
		}
		return result;
	}
}
