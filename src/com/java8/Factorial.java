package com.java8;

import java.util.*;

public class Factorial {
	private static final int SIZE = 10000;
	private static final int NUM = 10000;

	public static void main(String[] args) {

		Factorial fa = new Factorial();
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorialNoRecursive(i % NUM);
		}
		long end = System.currentTimeMillis();
		System.out.println("factorial no recursive:		" + (end - start));
		start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorial(i % NUM, 1);
		}
		end = System.currentTimeMillis();
		System.out.println("factorial(int n, int factor):	" + (end - start));
		start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorial(i % NUM);
		}
		end = System.currentTimeMillis();
		System.out.println("factorial(int n):		" + (end - start));
	}

	public long factorialNoRecursive(int n) {
		if (n == 0) {
			return 1;
		}
		int result = 1;
		while (n > 0) {
			result *= n;
			n--;
		}
		return result;
	}

	public long factorial(int n, int factor) {
		if (n == 0) {
			return factor;
		}
		return factorial(n - 1, n * factor);
	}

	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	public List<List<String>> accountsMerge(List<List<String>> accounts) {        
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        Account[] accs = new Account[accounts.size()];        
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < accounts.size(); i++){
            accs[i] = new Account(i, accounts.get(i));
            for(String e : accs[i].emails){
                map.putIfAbsent(e, new ArrayList<Integer>());
                map.get(e).add(i);
            }
        }
        
        for(String e : map.keySet()){
            for(int i = 0; i < map.get(e).size()-1; i++){
                uf.union(map.get(e).get(i), map.get(e).get(i+1));
            }
        }
        
        Map<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++){
            int p = uf.find(i);
            groups.putIfAbsent(p, new ArrayList<Integer>());
            groups.get(p).add(i);
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(Integer i : groups.keySet()){
            List<String> list = new ArrayList<String>();
            list.add(accounts.get(i).get(0));
            for(int j : groups.get(i)){
                for(String s : accs[j].emails){
                    accs[i].addEmail(s);
                }
            }
            
            List<String> tmp = new ArrayList<String>(accs[i].emails);
            Collections.sort(tmp);
            
            list.addAll(tmp);
            res.add(list);
        }
        
        return res;
        
    }
    
    class Account{
        int id;
        String name;
        Set<String> emails = new HashSet<String>();
        public Account(int id, List<String> list){
            this.id = id;
            this.name = list.get(0);
            for(int i = 1; i < list.size(); i++){
                emails.add(list.get(i));
            }
        }
        
        void addEmail(String email){
            emails.add(email);
        }
    }
    
    class UnionFind{
        int[] ids = null;
        public UnionFind(int n){
            ids = new int[n];
            for(int i = 0; i < n; i++){
                ids[i] = i;
            }
        }
        int find(int x){
            while(ids[x] != x){
                x = ids[x];
            }
            return ids[x];
        }
        void union(int x, int y){
            int p = find(x);
            int q = find(y);
            if(p == q) return;
            if(p < q){
                ids[p] = q;
            }else{
                ids[q] = p;
            }
        }
    } 
}
