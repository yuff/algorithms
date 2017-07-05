package com.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		ThreadMXBean threadmxBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadmxBean.dumpAllThreads(false, false);
		for (ThreadInfo info: threadInfos) {
			System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
		}
		
		System.out.println("cpu count:" + Runtime.getRuntime().availableProcessors());
	}
}
