package com.wangf.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class UnboundedQueue implements IQueue {
	private List<Object> list = new ArrayList<>();

	@Override
	public void add(Object element) {
		list.add(element);
		System.out.println("Added: " + element);
	}

	@Override
	public void remove(int index) {
		Object removed = list.remove(index);
		System.out.println("Removed: " + removed);
	}

	@Override
	public int size() {
		int size = list.size();
		return size;
	}

}
