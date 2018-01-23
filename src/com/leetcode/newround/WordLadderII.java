package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class WordLadderII {
	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		List<String> wordList = CommonUtil.buildList(new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
		List<String> wordList1 = CommonUtil.buildList(new String[] {"a", "b", "c", "d", "e", "f"});
		System.out.println(wl.findLadders("a", "c", wordList1));
		System.out.println(wl.findLadders("hit", "cog", wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
			return new ArrayList<>();
		}
		if (!wordList.contains(beginWord)) {			
			wordList.add(beginWord);
		}
		Map<String, WordNode> nodes = processWords(wordList);
		Map<String, Boolean> process = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		List<String> curProcess = new ArrayList<>();
		curProcess.add(beginWord);
		boolean found = false;
		while (!curProcess.isEmpty() && !found) {
			List<String> tmp = new ArrayList<>();
			for (String word : curProcess) {
				if (process.get(word) != null && process.get(word)) {
					continue;
				}
				WordNode node = nodes.get(word);
				if (endWord.equals(word)) {
					result.addAll(buildPath(node));
					found = true;
				}
				for(String t: node.transforms) {
					if (process.get(t) == null && !curProcess.contains(t)) {
						tmp.add(t);
						nodes.get(t).pre.add(node);
					}
				}
				process.put(word, true);
			}
			curProcess = tmp;
		}
		return result;

	}

	private List<List<String>> buildPath(WordNode node) {
		List<List<String>> result = new ArrayList<>();
		if (node.pre == null || node.pre.size() == 0) {
			List<String>list =  new ArrayList<>();
			list.add(node.word);
			result.add(list);
		} else {
			List<List<String>> tmp = new ArrayList<>();
			for(WordNode wn: node.pre) {
				tmp.addAll(buildPath(wn));
			}
			for(List<String> l: tmp) {
				l.add(node.word);
				result.add(l);
			}
		}
		return result;
	}

	private Map<String, WordNode> processWords(List<String> wordList) {
		Map<String, WordNode> result = new HashMap<>();
		for (String s : wordList) {
			result.put(s, new WordNode(s));
		}
		int n = wordList.size();
		for (int i = 0; i < n; i++) {
			String s1 = wordList.get(i);
			for (int j = i + 1; j < n; j++) {
				String s2 = wordList.get(j);
				if (isDistanceFit(s1, s2)) {
					result.get(s1).transforms.add(s2);
					result.get(s2).transforms.add(s1);
				}
			}
		}
		return result;
	}

	private boolean isDistanceFit(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int len = s1.length(), dis = 0;
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				dis++;
			}
			if (dis > 1) {
				break;
			}
		}
		return dis == 1;
	}
	class WordNode {
		List<WordNode> pre;
		String word;
		List<String> transforms;

		WordNode(String word) {
			this.word = word;
			transforms = new ArrayList<>();
			pre = new ArrayList<>();
		}
	}
}
