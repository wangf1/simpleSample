package com.wangf.patterns.observer;

public class Observer1 implements IObserver {

	@Override
	public void update(String message) {
		System.out.println("Observer1 updated with " + message);
	}

}
