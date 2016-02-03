package com.wangf.javaconcurrency;

import java.util.concurrent.CountDownLatch;

public class LatchesTest {

	private void fiveThreadStartTogether() throws InterruptedException {
		System.out.println("---------------fiveThreadStartTogether-------------------");
		CountDownLatch startGate = new CountDownLatch(1);
		int numberOfThread = 5;
		CountDownLatch endGate = new CountDownLatch(numberOfThread);

		for (int i = 0; i < numberOfThread; i++) {
			final int j = i;
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						startGate.await();
						System.out.println("Thread " + j + " started.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						endGate.countDown();
					}
				}
			};
			t.start();
		}
		startGate.countDown();
		endGate.await();
		System.out.println("Now all threads finished.");
	}

	private void thread1WaitThread2() {
		System.out.println("---------------thread1WaitThread2-------------------");
		CountDownLatch latch = new CountDownLatch(1);

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				try {
					latch.await();
					System.out.println("Thread 1 is started, so I (Thread 2) start now.");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		};
		thread1.start();

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("I (Thread 1) is started.");
				latch.countDown();
			};
		};
		thread2.start();

	}

	public static void main(String[] args) throws InterruptedException {
		LatchesTest latchesTest = new LatchesTest();
		latchesTest.fiveThreadStartTogether();
		latchesTest.thread1WaitThread2();
	}
}
