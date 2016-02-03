package com.wangf.javaconcurrency;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	private ConcurrentLinkedQueue<String> pool = new ConcurrentLinkedQueue<String>();
	private Semaphore semaphore = new Semaphore(5);

	public SemaphoreDemo() {
		init();
	}

	private void init() {
		for (int i = 1; i <= 5; i++) {
			pool.add("Object" + i);
		}
	}

	private void useObjectFromPool() throws InterruptedException {
		semaphore.acquire();
		try {
			String object = pool.poll();
			System.out.println(Thread.currentThread().getName() + ": Use object from pool and then return: " + object);
			int sleepTime = new Random().nextInt(5);
			Thread.sleep(sleepTime * 1000);
			pool.add(object);
		} finally {
			semaphore.release();
		}
	}

	private void multiThreadUseThePool() {
		Runnable runnable = () -> {
			try {
				useObjectFromPool();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		for (int i = 1; i <= 10; i++) {
			Thread thread = new Thread(runnable, "Thread" + i);
			thread.start();
		}
	}

	public static void main(String[] args) {
		new SemaphoreDemo().multiThreadUseThePool();
	}
}
