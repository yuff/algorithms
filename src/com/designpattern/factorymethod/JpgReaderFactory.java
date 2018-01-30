package com.designpattern.factorymethod;

public class JpgReaderFactory implements PictureReaderFactory {

	@Override
	public PictureReader reader() {
		return new JpgPictureReader();
	}

}
