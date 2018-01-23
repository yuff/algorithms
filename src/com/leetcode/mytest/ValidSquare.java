package com.leetcode.mytest;

public class ValidSquare {
	public static void main(String[] args) {
		ValidSquare vs = new ValidSquare();
		System.out.println(vs.validSquare(new int[] {0, 0}, new int[] {5, 0}, new int[] {5, 4}, new int[] {0, 4}));
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		if (!valid(p1) || !valid(p2) || !valid(p3) || !valid(p4)) {
			return false;
		}
		int[] a, b, c, d;
		int[] p21 = new int[] {p2[0] - p1[0], p2[1] - p1[1]};
		int[] p31 = new int[] {p3[0] - p1[0], p3[1] - p1[1]};
		int[] p41 = new int[] {p4[0] - p1[0], p4[1] - p1[1]};
		if (isRightAngle(p21, p31) && isSameLen(p21, p31)) {
			a = p1;
			b = p2;
			c = p3;
			d = p4;
		}
		else if (isRightAngle(p41, p31) && isSameLen(p41, p31)) {
			a = p1;
			b = p3;
			c = p4;
			d = p2;
		}
		else if (isRightAngle(p21, p41) && isSameLen(p21, p41)) {
			a = p1;
			b = p2;
			c = p4;
			d = p3;
		}
		else {
			return false;
		}
		return isSquare(a, b, c, d);
	}

	private boolean isSameLen(int[] p21, int[] p31) {
		int len21 = p21[0] * p21[0] + p21[1] * p21[1];
		int len31 = p31[0] * p31[0] + p31[1] * p31[1];
		return len21 > 0 && len21 == len31;
	}

	public boolean isRightAngle(int[] a, int[] b) {
		return a[0] * b[0] + a[1] * b[1] == 0;
	}

	private boolean isSquare(int[] a, int[] b, int[] c, int[] d) {
		int[] ab = new int[] {a[0] - b[0], a[1] - b[1]};
		int[] db = new int[] {d[0] - b[0], d[1] - b[1]};
		if (!isRightAngle(ab, db) || !isSameLen(ab, db)) {
			return false;
		}
		int[] ac = new int[] {a[0] - c[0], a[1] - c[1]};
		int[] dc = new int[] {d[0] - c[0], d[1] - c[1]};
		if (!isRightAngle(ac, dc) || !isSameLen(ac, dc)) {
			return false;
		}
		return true;
	}

	private boolean valid(int[] p) {
		if (p == null || p.length != 2) {
			return false;
		}
		return true;
	}
}
