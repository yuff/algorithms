package com.sap.i336048;

/**
 * VM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 * 
 * log:[GC (Allocation Failure) [ParNew: 5791K->311K(9216K), 0.0027138 secs] 5791K->5433K(19456K),
 * 0.0027754 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew:
 * 6615K->6615K(9216K), 0.0000480 secs][CMS: 5122K->9216K(10240K), 0.0048640 secs]
 * 11737K->11557K(19456K), [Metaspace: 2600K->2600K(1056768K)], 0.0050080 secs] [Times: user=0.01
 * sys=0.00, real=0.01 secs] [GC (CMS Initial Mark) [1 CMS-initial-mark: 9216K(10240K)]
 * 13605K(19456K), 0.0003680 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-mark-start] [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00,
 * real=0.00 secs] [CMS-concurrent-preclean-start] [CMS-concurrent-preclean: 0.000/0.000 secs]
 * [Times: user=0.00 sys=0.00, real=0.00 secs] [CMS-concurrent-abortable-preclean-start]
 * [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (CMS Final Remark) [YG occupancy: 4553 K (9216 K)][Rescan (parallel) , 0.0003200 secs][weak
 * refs processing, 0.0000070 secs][class unloading, 0.0001596 secs][scrub symbol table, 0.0003618
 * secs][scrub string table, 0.0001415 secs][1 CMS-remark: 9216K(10240K)] 13769K(19456K), 0.0010720
 * secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [CMS-concurrent-sweep-start]
 * [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-reset-start] [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00,
 * real=0.00 secs] Heap par new generation total 9216K, used 4553K [0x00000000fec00000,
 * 0x00000000ff600000, 0x00000000ff600000) eden space 8192K, 55% used [0x00000000fec00000,
 * 0x00000000ff072588, 0x00000000ff400000) from space 1024K, 0% used [0x00000000ff500000,
 * 0x00000000ff500000, 0x00000000ff600000) to space 1024K, 0% used [0x00000000ff400000,
 * 0x00000000ff400000, 0x00000000ff500000) concurrent mark-sweep generation total 10240K, used 9216K
 * [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000) Metaspace used 2606K, capacity
 * 4486K, committed 4864K, reserved 1056768K class space used 284K, capacity 386K, committed 512K,
 * reserved 1048576K
 *
 */
public class AllocationTest {

	private final static int _1MB = 1024 * 1024;

	public static void testAllocation() {
		byte[] a1, a2, a3, a4, a5;
		a5 = new byte[5 * _1MB];
		a4 = new byte[3 * _1MB];
		a2 = new byte[2 * _1MB];
		a1 = new byte[6 * _1MB];
		a3 = new byte[1 * _1MB];
	}

	public static void main(String[] args) {
		AllocationTest.testAllocation();
	}
}
