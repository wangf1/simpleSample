package com.wangf.patterns.proxy;

public class BoundedQueueProxy implements IQueue {

	private int bound;
	private IQueue queue;

	public BoundedQueueProxy(int bound, IQueue queue) {
		this.bound = bound;
		this.queue = queue;
	}

	@Override
	public void add(Object element) {
		if (queue.size() >= bound) {
			System.out.println("WARN: Exceed queue capability: " + bound + ". Cannot add " + element);
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
