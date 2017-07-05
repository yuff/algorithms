package com.java8;

public class Matrix {

    public void rotate(int[][] matrix) {
        int matrixLen = matrix.length;
        if (matrixLen == 0) {
            return ;
        }
        int column = matrix[0].length;
        if (matrixLen != column) {
            return ;
        }
        int len = matrixLen;
        for (int i = 0; i < matrixLen - i; i++) {
            for (int j = i ; j < matrixLen - i - 1 && len > 0 ; j++) {
                swap(matrix, matrixLen - 1, i, j);
            }
            len -= 2;
        }
    }
    void swap(int[][] matrix, int n, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n - j][i];
        matrix[n-j][i] = matrix[n-i][n-j];
        matrix[n-i][n-j] = matrix[j][n - i];
        matrix[j][n - i] = tmp;     
    }
    
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		System.out.println(matrix.length);
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
		matrix[0] = new int[] {1, 2, 3, 4};
		matrix[1] = new int[] {5, 6, 7, 8};
		matrix[2] = new int[] {9, 10, 11,12};
		matrix[3] = new int[] {13, 14, 15,16};
		System.out.println(matrix[0][0]+ "," + matrix[0][1]+ "," + matrix[0][2]  + "," +  matrix[1][0]+ "," + matrix[1][1]+ "," + matrix[1][2]  + "," +  matrix[2][0]+ "," + matrix[2][1]+ "," + matrix[2][2] );
		new Matrix().rotate(matrix);
		System.out.println(matrix[0][0]+ "," + matrix[0][1]+ "," + matrix[0][2]  + "," +  matrix[1][0]+ "," + matrix[1][1]+ "," + matrix[1][2]  + "," +  matrix[2][0]+ "," + matrix[2][1]+ "," + matrix[2][2] );
		System.out.println(matrix[1][1]+ "," + matrix[1][2]+ "," + matrix[2][1]  + "," +  matrix[2][2]);

	}
}
