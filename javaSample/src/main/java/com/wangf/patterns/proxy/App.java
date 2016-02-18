package com.wangf.patterns.proxy;

/**
 * Bellow is the difference between Proxy and Decorator pattern, quote from GoF
 * Design Patterns book.
 * 
 * <pre>
	Decorator (196): Although decorators can have similar implementations as proxies,
	decorators have a different purpose. A decorator adds one or more responsibilities
	to an object, whereas a proxy controls access to an object.
 * </pre>
 * 
 * In my mind, it pretty subtle to differentiate them, but I may not care it too
 * much.
 * 
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		IQueue unboundedQueue = new UnboundedQueue();
		unboundedQueue.add("String");
		unboundedQueue.add(123);

		IQueue boundedQueue = new BoundedQueueProxy(3, unboundedQueue);
		boundedQueue.add(2.5);
		boundedQueue.add("String2");

		IQueue typedBoundedQueue = new TypedQueueProxy(Integer.class, boundedQueue);
		typedBoundedQueue.remove(0);
		typedBoundedQueue.add("String3");
		typedBoundedQueue.add(456);
		typedBoundedQueue.add(789);
	}
}
