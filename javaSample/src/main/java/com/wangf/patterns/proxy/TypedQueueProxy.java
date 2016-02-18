package com.wangf.patterns.proxy;

public class TypedQueueProxy implements IQueue {

	private Class<?> type;
	private IQueue queue;

	public TypedQueueProxy(Class<?> type, IQueue queue) {
		this.type = type;
		this.queue = queue;
	}

	@Override
	public void add(Object element) {
		if (element.getClass() != type) {
			System.out.println(
					"WARN: Only allow " + type + ". " + element.getClass() + " not allowed. Cannot add " + element);
			return;
		}
		queue.add(element);
	}

	@Override
	public void remove(int index) {
		queue.remove(index);
	}

	@Override
	public int size() {
		return queue.size();
	}

}
