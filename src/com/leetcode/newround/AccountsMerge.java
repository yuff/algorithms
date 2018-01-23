package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class AccountsMerge {
	public static void main(String[] args) {
		AccountsMerge am = new AccountsMerge();
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(CommonUtil.buildList(new String[]{"David","David0@m.co","David4@m.co","David3@m.co"}));
		accounts.add(CommonUtil.buildList(new String[]{"David","David5@m.co","David5@m.co","David0@m.co"}));
		accounts.add(CommonUtil.buildList(new String[]{"David","David1@m.co","David4@m.co","David0@m.co"}));
		accounts.add(CommonUtil.buildList(new String[]{"David","David0@m.co","David1@m.co","David3@m.co"}));
		accounts.add(CommonUtil.buildList(new String[]{"David","David4@m.co","David1@m.co","David3@m.co"}));
		System.out.println(am.accountsMerge(accounts));
	}
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
        	return accounts;
        }
        int n = accounts.size();
        Map<String, Set<Integer>> map = new HashMap<>();
        Map<String, Boolean> emailMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        boolean[] process = new boolean[n];
        for(int i = 0; i < n; i++) {
        	List<String> list = accounts.get(i);
        	for(int j = 1; j < list.size(); j++) {
        		String email = list.get(j);
        		Set<Integer> set = map.getOrDefault(email, new HashSet<>());
        		set.add(i);
        		map.put(email, set);
        		emailMap.put(email, false);
        	}
        }
        for(String key: map.keySet()) {
        	if (!emailMap.get(key)) {
        		LinkedList<String> stack = new LinkedList<>();
        		Set<String> emailSet = new HashSet<>();
        		String name = null;
        		stack.push(key);
        		while (!stack.isEmpty()) {  
        			String k = stack.pop();
        			if (emailMap.get(k)) {
        				continue;
        			}
        			Set<Integer> set = map.get(k);
        			for(int id: set) {
        				if (!process[id]) {
        					List<String> account = accounts.get(id);
        					name = account.get(0);
        					for(int i = 1; i < account.size(); i++) {
        						String email = account.get(i);
        						emailSet.add(email);
        						stack.push(email);
        					}
        					process[id] = true;
        				}
        			}
        			emailMap.put(key, true);
        		}
        		if (name != null) {        			
        			List<String> emails = new ArrayList<>(emailSet);
        			Collections.sort(emails);
        			List<String> a = new ArrayList<>();
        			a.add(name);
        			a.addAll(emails);
        			result.add(a);
        		}
        	}
        }
        return result;
    }
}
