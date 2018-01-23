package com.leetcode.newround;

import java.util.*;

public class NetworkDelayTime {
	public static void main(String[] args) {
		NetworkDelayTime nd = new NetworkDelayTime();
		int[][] times = new int[][]{{2,1,1}, {2,3,1}, {3,4,1}};
		System.out.println(nd.networkDelayTime(times , 4, 2));
	}
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) {
        	return -1;
        }
        List<int[]>[] edges = new List[N + 1];
        int[] costs = new int[N + 1];
        Arrays.fill(costs, -1);
        buildEdges(edges, times);
        List<Integer> list = new ArrayList<>();
        list.add(K);
        costs[K] = 0;
        while(!list.isEmpty()) {
        	List<Integer> tmp = new ArrayList<>();
        	for(int num: list) {
        		processNode(num, edges, costs, tmp);
        	}
        	list = tmp;
        }
        int result = 0;
        for(int i = 1; i <= N;i++) {
        	int c = costs[i];
        	if (c < 0) {
        		return -1;
        	}
        	result = Math.max(result, c);
        }
        return result;
    }

	private void processNode(int num, List<int[]>[] edges, int[] costs, List<Integer> tmp) {
		int initCost = costs[num];
		List<int[]> tos = edges[num];
		if (tos == null || tos.isEmpty()) {
			return;
		}
		for(int[] to: tos) {
			int newVal = initCost + to[1];
			if (costs[to[0]] < 0 || costs[to[0]] > newVal) {
				tmp.add(to[0]);
				costs[to[0]] = newVal;
			}
		}
	}

	private void buildEdges(List<int[]>[] edges, int[][] times) {
		for(int[] time: times) {
			if (edges[time[0]] == null) {
				edges[time[0]] = new ArrayList<>();
			}
			edges[time[0]].add(new int[]{time[1], time[2]});
		}
	}
}
