package com.wangf.patterns.observer;

public class Observer2 implements IObserver {

	@Override
	public void update(String message) {
		System.out.println("Observer2 updated with " + message);
	}

}
