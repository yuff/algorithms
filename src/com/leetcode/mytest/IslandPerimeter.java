package com.leetcode.mytest;

/**
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0
 * represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is
 * completely surrounded by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to the water around
 * the island). One cell is a square with side length 1. The grid is rectangular, width and height
 * don't exceed 100. Determine the perimeter of the island.
 *
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = {{1 , 0}};
		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}

	public int islandPerimeter(int[][] grid) {
		int result = 0;
		int rowLen = grid.length;
		if (rowLen == 0 || grid[0].length == 0) {
			return result;
		}
		int columnLen = grid[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < columnLen; j++) {
				if (grid[i][j] == 1) {
					int added = 4;
					if (i >= 1 && grid[i - 1][j] == 1) {
						added -= 1;
					}
					if (i + 1 < rowLen && grid[i + 1][j] == 1) {
						added -= 1;
					}

					if (j >= 1 && grid[i][j - 1] == 1) {
						added -= 1;
					}
					if (j + 1 < columnLen && grid[i][j + 1] == 1) {
						added -= 1;
					}
					result += added;
				}
			}
		}
		return result;
	}
}
