package com.wangf.patterns.builder;

public class Director {
	private IBuilder builder;

	public Director(IBuilder builder) {
		this.builder = builder;
	}

	public com.wangf.patterns.builder.ICar construct() {
		builder.buildEngine();
		builder.buildOtherParts();
		ICar car = builder.construct();
		return car;
	}
}
