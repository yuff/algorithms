package com.interview;

import java.util.*;

import com.java8.util.CommonUtil;

/**
 * 1.定义了一个航班类，航班有出发地(string)，到达地(string)，出发时间(long)，航行时间(long)四个属性.
 * 2.还有一个字符串list，每个字符串代表一个地点，地点每出现一次，则代表那个地点有一组机组成员. 3.输入一个航班list，
 * 和上面提到过的字符串list，问能否利用提供的机组成员实现所有航班的运行。. 鍥磋鎴戜滑@1point 3 acres
 * 
 * 一个栗子：航班1{A, B, 3, 10}, 航班2{A, C, 1, 7}, 航班3{C, D, 9, 11} 机组成员list{"A", "A"} 那么就return true，
 * 因为首先航班1和航班2起飞，然后航班2降落，把机组成员从A地带到了B地，所以航班3可以起飞。 如果航班3是{C, D, 6, 12}, 那么就return
 * false，因为时刻6没有机组成员在C地
 *
 */
public class FlightArrange {

	public static void main(String[] args) {
		FlightArrange fa = new FlightArrange();
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("a","b", 3l,10l));
		flights.add(new Flight("a","c", 1l,7l));
		flights.add(new Flight("c","d", 6l,11l));
		List<String> crews = CommonUtil.buildList(new String[]{"a","a"});
		System.out.println(fa.canFlightFinished(flights , crews));
	}
	public boolean canFlightFinished(List<Flight> flights, List<String> crews) {
		if (flights == null || flights.size() == 0) {
			return true;
		} else if (crews == null || crews.size() == 0)
		Collections.sort(flights, (a, b) -> {
			return a.startTime - b.startTime > 0 ? 1 : (a.startTime - b.startTime == 0? 0: -1);
		});
		Map<String, PriorityQueue<Long>> map = new HashMap<>();
		for(String s: crews) {
			if (map.get(s) == null) {
				map.put(s, new PriorityQueue<Long>((a, b)->{
					return a - b > 0 ? 1 : (a - b == 0? 0: -1);
				}));
			}
			map.get(s).add(0l);
		}
		for(Flight f: flights) {
			String from = f.from;
			if (map.get(from) != null && map.get(from).poll() <= f.startTime) {
				PriorityQueue<Long> toQueue = map.getOrDefault(f.to, new PriorityQueue<Long>((a, b)->{
					return a - b > 0 ? 1 : (a - b == 0? 0: -1);
				}));
				toQueue.add(f.startTime + f.flightTime);
				map.put(f.to, toQueue);
			} else {
				return false;
			}
		}
		return true;
	}
}

class Flight {
	String from;
	String to;
	long startTime;
	long flightTime;
	
	Flight(String from, String to, long startTime, long flightTime) {
		this.from = from;
		this.to = to;
		this.flightTime = flightTime;
		this.startTime = startTime;
	}
}