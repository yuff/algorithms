package com.designpattern.factorymethod;

public class PictureMain {

	public static void main(String[] args) {
		PictureReaderFactory prf = new GifReaderFactory();
		System.out.println(prf.reader().read(new Picture() {
			@Override
			public String getName() {
				return "test.gif";
			}
		}));
		PictureReaderFactory prf1 = new JpgReaderFactory();
		System.out.println(prf1.reader().read(new Picture() {
			@Override
			public String getName() {
				return "test.jpg";
			}
		}));
	}
}
