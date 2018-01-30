package com.designpattern.abstractfactory;

public class WinPhoneControllerFactory implements ControllerFactory {

	@Override
	public OperationController getOperationController() {
		return new WinPhoneOperationController();
	}

	@Override
	public InterfaceController getInterfaceController() {
		return new WinPhoneInterfaceController();
	}

}
