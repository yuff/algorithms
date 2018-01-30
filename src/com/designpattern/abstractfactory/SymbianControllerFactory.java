package com.designpattern.abstractfactory;

public class SymbianControllerFactory implements ControllerFactory {

	@Override
	public OperationController getOperationController() {
		return new SymbianOperationController();
	}

	@Override
	public InterfaceController getInterfaceController() {
		return new SymbianInterfaceController();
	}

}
