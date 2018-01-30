package com.designpattern.abstractfactory;

public interface ControllerFactory {

	OperationController getOperationController();
	InterfaceController getInterfaceController();
}
