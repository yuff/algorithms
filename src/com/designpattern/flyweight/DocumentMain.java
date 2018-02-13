package com.designpattern.flyweight;

public class DocumentMain {

	public static void main(String[] args) {
		Document d1 = new Picture("pic1");
		Document d2 = new Picture("pic2");
		Document d3 = new Vedio("vedio1");
		Document d4 = new Vedio("vedio2");
		Document d5 = new Animation("animation1");
		Document d6 = new Animation("animation2");
		
		DocumentFactory df = DocumentFactory.getInstance();
		System.out.println(df.addDocument(d1));
		df.addDocument(d2);
		df.addDocument(d3);
		df.addDocument(d4);
		df.addDocument(d5);
		df.addDocument(d6);
		System.out.println(df.addDocument(d1));
		df.getDocument("Picture pic1").display(new DocumentInfo(1,1,3,5));
		df.getDocument("Vedio vedio1").display(new DocumentInfo(2,9,6,1));
		df.getDocument("Animation animation2").display(new DocumentInfo(12,3,32,53));
	}
}
