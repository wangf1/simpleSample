package com.wangf.patterns.proxy;

public interface IQueue {
	void add(Object element);

	void remove(int index);

	int size();
}
