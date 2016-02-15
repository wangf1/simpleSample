package com.wangf.patterns.builder;

public class AbstractCar implements ICar {
	private String engine;
	private String otherParts;

	@Override
	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public void setOtherParts(String otherParts) {
		this.otherParts = otherParts;
	}

	@Override
	public void run() {
		System.out.println(this + " on the road...");
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", otherParts=" + otherParts + "]";
	}

}
