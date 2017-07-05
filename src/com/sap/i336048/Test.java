package com.sap.i336048;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	static String reg = "(TenantId) eq '([^']*)'[^or]*and (UserId) eq '([^']*)'|(UserId) eq '([^']*)'[^or]*and (TenantId) eq '([^']*)'";
	static String reg1 = "^\\s*(TenantId)\\s*eq\\s*'([^']*)'\\s*and\\s*(UserId)\\s*eq\\s*'([^']*)'\\s*$|^\\s*(UserId)\\s*eq\\s*'([^']*)'\\s*and\\s*(TenantId)\\s*eq\\s*'([^']*)'\\s*$";
	static String reg2 = "([^;]*);?(boundary=[^;]*)?(;.*)?";
	static String reg3 = "\\s?(((?!boundary)[^;=])+)\\s?;?\\s?(boundary=\"?([^;\"]*)\"?)?(\\s?;.*)?";
	public static void main(String[] args) {		
		Pattern pattern = Pattern.compile(reg3);
		String s1 = "multipart/form-data;boundary=\"----WebKitFormBoundaryvL16wMMh3EBbGy5H\";charset=UTF-8";
		String s2 = "abc=cdf";
		String s3 = "multipart/form-data ; boundary=----canyouseeme;charset=UTF-8";
		String s4 = "application/json;";
		System.out.println("s1====" + s1.matches(reg3));
		Matcher ma = pattern.matcher(s1);
		if (ma.find()) {
			System.out.println(ma.groupCount());
			System.out.println("group 1:" +  ma.group(1));
			System.out.println("group 2 : " + ma.group(2));
			System.out.println("group 3 : " + ma.group(3));
			System.out.println("group 3 : " + ma.group(4));
		}
		System.out.println("s2====" + s2.matches(reg3));
		
		Matcher ma2 = pattern.matcher(s2);
		if (ma2.find()) {
			System.out.println(ma2.groupCount());
			System.out.println("group 1:" +  ma2.group(1));
			System.out.println("group 2 : " + ma2.group(2));
			System.out.println("group 3 : " + ma2.group(3));
		}
		
		System.out.println("s3====" +  s3.matches(reg3));
		Matcher ma3 = pattern.matcher(s3);
		if (ma3.find()) {
			System.out.println(ma3.groupCount());
			System.out.println("group 1:" +  ma3.group(1));
			System.out.println("group 2 : " + ma3.group(2));
			System.out.println("group 3 : " + ma3.group(3));
			System.out.println("group 4 : " + ma3.group(4));
		}
		
		System.out.println("s4====" +  s4.matches(reg3));
		Matcher ma4 = pattern.matcher(s4);
		if (ma4.find()) {
			System.out.println(ma3.groupCount());
			System.out.println("group 1:" +  ma4.group(1));
			System.out.println("group 2 : " + ma4.group(2));
			System.out.println("group 3 : " + ma4.group(3));
		}
		
//		String a = "UserId eq 'Etest001'  and TenantId eq 'Ttest001' ";
//		String b = "TenantId  eq  'abc' and UserId  eq   '123' ";
//		String c = "TenantId eq 'abc' and Email eq 'abcd@abc' and UserId eq '123'";
//		String d = "TenantId eq  'abc' and ( Email eq 'abc@ad' or UserId eq '123' )"  ;
//		String e = "FirstName eq 'test' and UserId eq '123'";
//		Matcher ma = pattern.matcher(a);
//		if (ma.find()) {			
//			System.out.println(ma.group(1));
//			System.out.println(ma.group(2));
//			System.out.println(ma.group(3));
//			System.out.println(ma.group(4));
//			System.out.println(ma.group(5));
//			System.out.println(ma.group(6));
//			System.out.println(ma.group(7));
//			System.out.println(ma.group(8));
//		}
//		System.out.println(pattern.matcher(a).find());
//		System.out.println(pattern.matcher(b).find());
//		System.out.println(pattern.matcher(c).find());
//		System.out.println(pattern.matcher(d).find());
//		
//		String s = "ABC[ This is to extract ]";
//        Pattern p = Pattern.compile(".*\\[ (.*) \\].*");
//        Matcher m = p.matcher(s);
//        m.find();
//        String text = m.group(1);
//        System.out.println(text);
	}
}
