package com.leetcode.mytest;

public class Trie {
	public static void main(String[] args) {
		Trie tire = new Trie();
		tire.insert("ab");
		System.out.println(tire.search("a"));
		System.out.println(tire.startsWith("a"));
	}
	TrieNode[] children;

	/** Initialize your data structure here. */
	public Trie() {
		children = new TrieNode[27];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		char[] arr = word.toCharArray();
		TrieNode[] nodes = children;
		for (char c : arr) {
			int id = c - 'a';
			if (nodes[id] == null) {
				nodes[id] = new TrieNode(c);
			}
			nodes = nodes[id].children;
		}
		nodes[26] = new TrieNode('.', null);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		char[] arr = word.toCharArray();
		TrieNode[] nodes = children;
		for (char c : arr) {
			int id = c - 'a';
			if (nodes == null || nodes[id] == null) {
				return false;
			}
			else {
				nodes = nodes[id].children;
			}
		}
		return nodes[26] != null && nodes[26].c == '.';
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return false;
		}
		char[] arr = prefix.toCharArray();
		TrieNode[] nodes = children;
		for (char c : arr) {
			int id = c - 'a';
			if (nodes == null || nodes[id] == null) {
				return false;
			}
			else {
				nodes = nodes[id].children;
			}
		}
		return true;
	}
}

class TrieNode {
	char c;
	TrieNode[] children;

	TrieNode(char c) {
		this.c = c;
		children = new TrieNode[27];
	}

	TrieNode(char c, TrieNode[] nodes) {
		this.c = c;
		children = nodes;
	}
}
