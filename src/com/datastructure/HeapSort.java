package com.datastructure;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = new int[]{3,4,2,5,6,8,1,9,18,12,22,16,19,9};
		int[] result = new HeapSort().heapSort(array);
		for(int i: result) {
			System.out.print(i);
			System.out.print(",");
		}
		
	}
	public int[] heapSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		buildMaxHeap(array);
		int length = array.length;
		int heapSize = length;
		while(heapSize > 1) {
			swap(array, 0, heapSize - 1);
			heapSize--;
			maxifyNode(array, 0, heapSize);
		}
		return array;
	}
	private void buildMaxHeap(int[] array) {
		int length = array.length;
		int size = (length - 1) >> 1;
		for(int i = size; i >=0; i--) {
			maxifyNode(array, i, length);
		}
	}
	private void maxifyNode(int[] array, int i, int heapSize) {
		int left = (i << 1) + 1;
		int right = (i << 1) + 2;
		int largest = i;
		if (left < heapSize && array[left] > array[largest]) {
			largest = left;
		}
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			swap(array, i, largest);
			maxifyNode(array, largest, heapSize);
		}
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
