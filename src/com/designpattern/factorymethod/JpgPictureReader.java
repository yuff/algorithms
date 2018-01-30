package com.designpattern.factorymethod;

public class JpgPictureReader  implements PictureReader{

	@Override
	public String read(Picture pic) {
		return pic.getName();
	}

}
