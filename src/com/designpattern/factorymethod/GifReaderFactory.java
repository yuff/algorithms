package com.designpattern.factorymethod;

public class GifReaderFactory implements PictureReaderFactory {

	@Override
	public PictureReader reader() {
		return new GifPictureReader();
	}

}
