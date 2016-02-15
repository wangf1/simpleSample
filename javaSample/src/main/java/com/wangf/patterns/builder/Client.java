package com.wangf.patterns.builder;

public class Client {
	private ICar buyAICar(CarType type) {
		IBuilder builder;
		switch (type) {
		case SUV:
			builder = new SUVBuilder();
			break;
		case SEDAN:
			builder = new SedanBuilder();
			break;
		default:
			builder = new SedanBuilder();
			break;
		}
		Director director = new Director(builder);
		ICar ICar = director.construct();
		return ICar;
	}

	public static void main(String[] args) {
		Client client = new Client();
		ICar sedan = client.buyAICar(CarType.SEDAN);
		sedan.run();
		ICar suv = client.buyAICar(CarType.SUV);
		suv.run();
	}
}
