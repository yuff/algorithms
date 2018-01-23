package com.leetcode.newround;

public class NQueensII {
	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(16));
	}
    public int totalNQueens(int n) {
        if (n  == 1) {
            return 1;
        } else if (n < 4) {
            return 0;
        }
        int[] arr = new int[n];
        int[] result = new int[1];
        boolean[] isPut = new boolean[n];
        nQueens(arr, result,isPut, 0);
        return result[0];
    }
    private void nQueens(int[] arr, int[] result, boolean[] isPut, int startIndex) {
        if (startIndex == arr.length) {
            result[0] += 1;
            return;
        }
        int n = arr.length;
        for(int i = 0; i < n; i++) {
        	if (!isPut[i]) {        		
        		if (canPut(arr, startIndex, i)) {
        			arr[startIndex] = i;
        			isPut[i] = true;
        			nQueens(arr, result,isPut, startIndex + 1);
        			isPut[i] = false;
        		}
        	}
        }
    }
    
    private boolean canPut(int[] arr, int index, int position) {
        boolean result = true;
        for(int i = 0; i < index; i++) {
            if ((Math.abs(arr[i] - position) == Math.abs(index - i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
