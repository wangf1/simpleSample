package com.wangf.javaconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
	private FutureTask<String> startTheFutureTask() {
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// Sleep 3 seconds to mimic a long running operation.
				Thread.sleep(3 * 1000);
				return "The result of the feature task";
			}
		});
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println("Future task started.");
		return futureTask;
	}

	private void doOtherThings() throws InterruptedException {
		Thread.sleep(2 * 1000);
		System.out.println("Other things done.");
	}

	private void doOtherThingWhileWaitFutureTask() throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = startTheFutureTask();
		doOtherThings();
		String futureTaskResult = futureTask.get();
		System.out.println(futureTaskResult);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTaskDemo demo = new FutureTaskDemo();
		demo.doOtherThingWhileWaitFutureTask();
	}
}
