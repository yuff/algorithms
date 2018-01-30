package com.designpattern.abstractfactory;

public class ControlMain {

	public static void main(String[] args) {
		ControllerFactory android = new AndroidControllerFactory();
		android.getInterfaceController().control();
		android.getOperationController().control();
		ControllerFactory symbian = new SymbianControllerFactory();
		symbian.getInterfaceController().control();
		symbian.getOperationController().control();
		ControllerFactory winPhone = new WinPhoneControllerFactory();
		winPhone.getInterfaceController().control();
		winPhone.getOperationController().control();
	}
}
