package com.wangf.javaconcurrency;

import java.lang.InterruptedException;

public class InterruptDemo {

	private void stopByInterrupt() {
		Runnable runnable = () -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(3000);
					// mainThread.interrupt();
				} catch (InterruptedException e) {
					// In fact the code will not possible go here, since when
					// interrupted, the while loop exit.
					Thread.currentThread().interrupt();
				}
				System.out.println("Running...");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// The main thread want sleep 5 seconds without interrupt.
		}
		// The call of interrupt will make the thread exit the while loop.
		thread.interrupt();
		System.out.println("Done");
	}

	public static void main(String[] args) {
		InterruptDemo demo = new InterruptDemo();
		demo.stopByInterrupt();
	}
}
