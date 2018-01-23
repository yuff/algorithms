package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class EvaluateDivision {
	public static void main(String[] args) {
		EvaluateDivision ed = new EvaluateDivision();
		String[][] equations = new String[3][2];
		equations[0] = new String[]{"a", "b"};
		equations[1] = new String[]{"b", "c"};
		equations[2] = new String[]{"d", "c"};
		double[] values = new double[]{2.0, 3.0, 4.0};
		String[][] queries = new String[5][2];
		queries[0] = new String[]{"b", "c"};
		queries[1] = new String[]{"b", "a"};
		queries[2] = new String[]{"a", "c"};
		queries[3] = new String[]{"b", "c"};
		queries[4] = new String[]{"x", "x"};
		CommonUtil.print(ed.calcEquation(equations, values, queries));
	}
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	if(queries == null || queries.length == 0 ) {
    		return new double[0];
    	}
    	int m = queries.length;
    	double[] result = new double[m];
    	Arrays.fill(result, -1.0);
        if (equations == null || values == null || equations.length == 0 || equations.length != values.length) {
        	return result;
        }
        Map<String,Vertical> map = buildVertical(equations, values);
        for(int i = 0; i < m; i++) {
        	String[] query = queries[i];
        	String start = query[0], end = query[1];
        	result[i] = calculateCost(map, start, end);
        }
        return result;
    }

	private double calculateCost(Map<String, Vertical> map, String start, String end) {
    	Map<String, Boolean> processMap = new HashMap<>();
		Vertical vs = map.get(start);
		if (vs == null || vs.edges == null) {
			return -1;
		} else if (start.equals(end)) {
			return 1.0;
		}
		List<Edge> list = vs.edges;
		initEdges(list);
		processMap.put(start, true);
		while (!list.isEmpty()) {
			List<Edge> tmp = new ArrayList<>();
			for(Edge edge: list) {
				if (edge.toVertical.value.equals(end)) {
					return edge.curCost;
				} else {
					processMap.put(edge.fromVertical.value, true);
					for(Edge e: edge.toVertical.edges) {
						if (processMap.get(e.toVertical.value) == null) {
							e.curCost = e.weight * edge.curCost;
							tmp.add(e);							
						}
					}
				}
			}
			list = tmp;
		}
		return -1.0;
	}

	private void initEdges(List<Edge> list) {
		for(Edge edge: list) {
			edge.resetCurCost();
		}
	}
	private Map<String, Vertical> buildVertical(String[][] equations, double[] values) {
		Map<String, Vertical> map = new HashMap<>();
		int n = equations.length;
		for(int i = 0; i < n; i++) {
			String s = equations[i][0], e = equations[i][1];
			double value = values[i];
			if (map.get(s) == null) {
				map.put(s, new Vertical(s));
			}
			if (map.get(e) == null) {
				map.put(e, new Vertical(e));
			}
			map.get(s).edges.add(new Edge(map.get(s),map.get(e), value));
			map.get(e).edges.add(new Edge(map.get(e), map.get(s), 1/value));
		}
		return map;
	}
}

class Vertical {
	Vertical(String value) {
		this.value = value;
		this.edges = new ArrayList<>();
	}
	String value;
	List<Edge> edges;
}

class Edge {
	Edge(Vertical fromVertical, Vertical toVertical, double weight) {
		this.fromVertical = fromVertical;
		this.toVertical = toVertical;
		this.weight = weight;
		this.curCost = weight;
	}
	void resetCurCost() {
		this.curCost = this.weight;
	}
	Vertical fromVertical;
	Vertical toVertical;
	double weight;
	double curCost; 
}
