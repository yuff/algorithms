package com.leetcode.newround;

import java.util.*;

public class WordSearchII {
	public static void main(String[] args) {
		WordSearchII ws = new WordSearchII();
		char[][] board = new char[4][4];
		board[0] = new char[] {'o', 'a', 'a', 'n'};
		board[1] = new char[] {'e', 't', 'a', 'e'};
		board[2] = new char[] {'i', 'h', 'k', 'r'};
		board[3] = new char[] {'i', 'f', 'l', 'v'};
		String[] words = new String[] {"oath", "pea", "eat", "rain"};

		char[][] board1 = new char[2][2];
		board1[0] = new char[] {'a', 'b'};
		board1[1] = new char[] {'c', 'd'};
		String[] words1 = new String[] {"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb",
		                                "acb"};
		System.out.println(ws.findWords(board1, words1));
	}

	public List<String> findWords(char[][] board, String[] words) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return new ArrayList<>();
		}
		int m = board.length, n = board[0].length;
		TrieNode root = buildTrie(words);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				findWords(root, board, i, j, result);
			}
		}
		return result;
	}

	private void findWords(TrieNode node, char[][] board, int i, int j, List<String> result) {
		char c = board[i][j];
		int id = c - 'a';
		if (c == '#' || node.children[id] == null) {
			return;
		}
		node = node.children[id];

		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[i][j] = '#';
		if (i > 0) {
			findWords(node, board, i - 1, j, result);
		}
		if (i < board.length - 1) {
			findWords(node, board, i + 1, j, result);
		}
		if (j > 0) {
			findWords(node, board, i, j - 1, result);
		}
		if (j < board[0].length - 1) {
			findWords(node, board, i, j + 1, result);
		}
		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			char[] arr = word.toCharArray();
			TrieNode node = root;
			for (char c : arr) {
				int id = c - 'a';
				if (node.children[id] == null) {
					node.children[id] = new TrieNode();
				}
				node = node.children[id];
			}
			node.word = word;
		}
		return root;
	}
}

class TrieNode {
	String word;
	TrieNode[] children;

	TrieNode() {
		children = new TrieNode[26];
	}
}
