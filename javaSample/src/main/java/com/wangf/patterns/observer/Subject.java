package com.wangf.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<IObserver> observers = new ArrayList<>();

	public void addObserver(IObserver observer) {
		observers.add(observer);
	}

	public void update(String value) {
		System.out.println("Subject updated with " + value);
		notifyObservers(value);
	}

	private void notifyObservers(String value) {
		observers.forEach(observer -> {
			observer.update(value);
		});
	}

}
