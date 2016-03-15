package com.wangf.patterns.strategy;

public class FlyWithWing implements IFlyStrategy {

	@Override
	public void fly() {
		System.out.println("Fly with wing!");
	}

}
