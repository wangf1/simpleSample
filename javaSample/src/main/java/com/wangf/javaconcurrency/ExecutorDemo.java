package com.wangf.javaconcurrency;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	private void executeWithFixedThreadPool() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			int j = i;
			Runnable task = () -> {
				System.out.println(Thread.currentThread().getName() + ": Task " + j + " begin....");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ": Task " + j + " done.");
			};
			executor.execute(task);
		}
		executor.shutdown();
	}

	private void executeWithScheduledThreadPool() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		Runnable command = () -> {
			System.out.println("Command runs at " + new Date());
		};
		executor.scheduleAtFixedRate(command, 0, 5, TimeUnit.SECONDS);
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
	}

	public static void main(String[] args) {
		ExecutorDemo demo = new ExecutorDemo();
		demo.executeWithFixedThreadPool();
		demo.executeWithScheduledThreadPool();
	}
}
