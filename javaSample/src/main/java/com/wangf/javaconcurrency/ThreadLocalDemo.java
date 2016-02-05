package com.wangf.javaconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	private static ThreadLocal<Integer> threadExecuteTimes = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		};
	};

	private void testThreadLocal() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			Callable<Void> callable = createACallable();
			executor.submit(callable);
		}
		executor.shutdown();
	}

	private Callable<Void> createACallable() {
		Callable<Void> callable = () -> {
			int count = threadExecuteTimes.get();
			count++;
			System.out.println("Thread " + Thread.currentThread().getName() + " handle totally " + count + " tasks.");
			threadExecuteTimes.set(count);
			printAddtionalMessage();
			Thread.sleep(300);
			return null;
		};
		return callable;
	}

	/**
	 * This method demonstrate why use the thread local as a static field:<br>
	 * Multiple method can access the thread local object easily.
	 * 
	 * @param count
	 */
	private void printAddtionalMessage() {
		System.out.println(
				"(Addtional message): " + Thread.currentThread().getName() + ":" + threadExecuteTimes.get() + ".");
	}

	public static void main(String[] args) {
		ThreadLocalDemo demo = new ThreadLocalDemo();
		demo.testThreadLocal();
	}
}
