package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicateFileInSystem {

	public static void main(String[] args) {
		FindDuplicateFileInSystem fdfs = new FindDuplicateFileInSystem();
		String[] paths = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
		                               "root 4.txt(efgh)"};
		List<List<String>> result = fdfs.findDuplicate(paths);
		for(List<String> l: result) {
			System.out.println(l);
		}
	}

	public List<List<String>> findDuplicate(String[] paths) {
		if (paths == null | paths.length == 0) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			resolvePath(path, map);
		}
		List<List<String>> result = new ArrayList<>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			result.add(map.get(key));
		}
		return result;
	}

	private void resolvePath(String path, Map<String, List<String>> map) {
		String[] strs = path.split(" ");
		String basePath = strs[0];
		int len = strs.length;
		for (int i = 1; i < len; i++) {
			int index1 = strs[i].indexOf("(");
			int index2 = strs[i].indexOf(")");
			String fileName = strs[i].substring(0, index1);
			String content = strs[i].substring(index1 + 1, index2);
			if (map.get(content) == null) {
				map.put(content, new ArrayList<>());
			}
			map.get(content).add(basePath + "/" + fileName);
		}
	}
}
