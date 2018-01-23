package com.leetcode.newround;

public class CountTheRepetitions {
	public static void main(String[] args) {
		CountTheRepetitions cp = new CountTheRepetitions();
		String s1 = "adasfdgdftadwfwfereredsfssas";
		String s2 = "fw";
		System.out.println(cp.getMaxRepetitions(s1, 500, s2, 555));
	}

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (s1 == null || s2 == null || n1 == 0 || n2 == 0) {
			return 0;
		}
		if (s1.length() * n1 < s2.length() * n2) {
			return 0;
		}
		int n = Math.max(n1 / n2, n1 % n2);
		int[] counts = new int[n];
		int[] remains = new int[n];
		int[] res = findStr(s1, s2);
		counts[0] = res[0];
		remains[0] = res[1];
		int i = 0;
		if (counts[0] == 0 || remains[0] != 0) {
			i = 1;
			while (i < n) {
				String str = generateStr(s1, remains[i - 1]);
				int[] tmp = findStr(str, s2);
				counts[i] = counts[i - 1] + tmp[0];
				remains[i] = tmp[1];
				if (counts[i] > 0 && remains[i] == 0) {
					break;
				}
				else {
					i++;
				}
			}
		}
		int multi = n / (i + 1), remain = n % (i + 1);
		if (multi > 0) {
			counts[n - 1] = multi * counts[i] + (remain > 0 ? counts[remain - 1] : 0);
		}
		return n1 / n2 > 0 ? counts[n1 / n2 - 1] : 0 + n1 % n2 > 0 ? counts[n1 % n2 - 1] / n2 : 0;
	}

	private String generateStr(String s1, int remain) {
		int len = s1.length();
		int repeat = 1;
		StringBuilder sb = new StringBuilder();
		repeat += (remain / len);
		remain %= len;
		if (remain > 0) {
			sb.append(s1.substring(len - remain));
		}
		while (repeat > 0) {
			sb.append(s1);
			repeat--;
		}
		return sb.toString();
	}

	private int[] findStr(String str, String s2) {
		int m = str.length(), n = s2.length();
		int[] result = new int[2];
		if (m < n) {
			result[0] = 0;
			result[1] = m;
		}
		else {
			int i = 0, remain = m, count = 0;
			while (i < m) {
				int j = 0,  curI = 0;
				while (i < m && j < n) {
					if (str.charAt(i) == s2.charAt(j)) {
						i++;
						curI++;
						j++;
					}
					else {
						curI++;
						i++;
					}
				}
				if (j == n) {
					remain -= curI;
					count++;
				}
			}
			result[0] = count;
			result[1] = remain;
		}
		return result;
	}

}
