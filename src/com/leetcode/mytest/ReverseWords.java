package com.leetcode.mytest;

public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		String result = rw.reverseWords("a's s'a x's");
		System.out.println(result);
	}
    public String reverseWords(String s) {
    	if (s == null || s.isEmpty()) {
    		return s;
    	}
    	String[] sArray = s.split("[\\s]");
    	StringBuilder builder = new StringBuilder();
    	for(String str: sArray) {
    		builder.append(reverseWord(str));
    		builder.append(" ");
    	}
    	builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
    }
    
    private String reverseWord(String s) {
    	int length = s.length();
    	char[] charArray = s.toCharArray();
    	int beginIndex = 0;
    	int reverseIndex = length -1;
    	while (beginIndex >= 0 && reverseIndex >= 0 && beginIndex < reverseIndex) {
    		char tmp = charArray[beginIndex];
    		charArray[beginIndex] = charArray[reverseIndex];
    		charArray[reverseIndex] = tmp;
    		beginIndex++;
    		reverseIndex--;
    	}

    	return new String(charArray);
    }
}
