package com.wangf.patterns.bridge;

public class OnpemiseService implements IServcie {

	private IServcieImpl impl;

	public OnpemiseService(IServcieImpl impl) {
		this.impl = impl;
	}

	@Override
	public void getCustomerAndOrders(String cusotmerID) {
		System.out.println("=====Onpremise=====");
		impl.accessDatabase("select customer by ID: " + cusotmerID);
		impl.accessDatabase("Select orders for customer: " + cusotmerID);
	}

}
