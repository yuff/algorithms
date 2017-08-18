package com.leetcode.mytest;

public class StudentAttendanceRecordI {

	public static void main(String[] args) {
		StudentAttendanceRecordI sa = new StudentAttendanceRecordI();
		System.out.println(sa.checkRecord("PPALLP"));
		System.out.println(sa.checkRecord("LLPPPLL"));
	}
    public boolean checkRecord(String s) {
        if (s == null || s.isEmpty()) {
        	return true;
        }
        boolean result = true;
        boolean preLate = false;
        int absent = 0, late = 0, n = s.length();
        for(int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (c == 'A') {
        		absent++;
        		preLate = false;
        		late = 0;
        	} else if (c == 'L') {
        		if (late == 0 || preLate) {        			
        			late++;
        		}
        		preLate = true;
        	} else {
        		late = 0;
        		preLate = false;
        	}
        	if (absent > 1 || late > 2) {
        		result = false;
        		break;
        	}
        }
        return result;
    }	
}
