package com.wangf.patterns.bridge;

public class OnCloudService implements IServcie {

	private IServcieImpl impl;

	public OnCloudService(IServcieImpl impl) {
		this.impl = impl;
	}

	@Override
	public void getCustomerAndOrders(String cusotmerID) {
		System.out.println("=====On Cloud=====");
		impl.accessDatabase("select customer by ID: " + cusotmerID);
		impl.accessDatabase("Select orders for customer: " + cusotmerID);
	}
}
