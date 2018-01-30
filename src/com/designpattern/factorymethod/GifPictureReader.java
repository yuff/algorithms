package com.designpattern.factorymethod;

public class GifPictureReader implements PictureReader {

	@Override
	public String read(Picture pic) {
		return pic.getName();
	}

}
