package com.wangf.patterns.observer;

public class App {
	public static void main(String[] args) {
		Subject subject = new Subject();
		IObserver observer1 = new Observer1();
		subject.addObserver(observer1);
		subject.addObserver(new Observer2());
		subject.update("Value1");
	}
}
