package com.designpattern.abstractfactory;

public class AndroidControllerFactory implements ControllerFactory {

	@Override
	public OperationController getOperationController() {
		return new AndroidOperationController();
	}

	@Override
	public InterfaceController getInterfaceController() {
		return new AndroidInterfaceController();
	}

}
