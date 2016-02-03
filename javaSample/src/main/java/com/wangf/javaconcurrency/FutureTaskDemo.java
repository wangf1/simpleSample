package com.wangf.javaconcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskDemo {
	private List<Future<String>> startTheFutureTask() {
		List<Future<String>> futures = new ArrayList<>();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			int j = i;
			Callable<String> callable = () -> {
				System.out.println("Future task started: " + j);
				int sleep = new Random().nextInt(5);
				Thread.sleep(sleep * 1000);
				return "The result of the feature task: " + j;
			};
			FutureTask<String> futureTask = new FutureTask<String>(callable);
			executor.submit(futureTask);
			futures.add(futureTask);
		}
		executor.shutdown();
		return futures;
	}

	private void doOtherThings() throws InterruptedException {
		Thread.sleep(2 * 1000);
		System.out.println("Other things done.");
	}

	private void doOtherThingWhileWaitFutureTask() throws InterruptedException {
		List<Future<String>> futures = startTheFutureTask();
		doOtherThings();
		futures.forEach(f -> {
			String futureTaskResult;
			try {
				futureTaskResult = f.get(2, TimeUnit.SECONDS);
				System.out.println(futureTaskResult);
			} catch (TimeoutException e) {
				System.out.println("Task " + f + " not finish in 2 seconds.");
			} catch (Exception e) {

			}

		});
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTaskDemo demo = new FutureTaskDemo();
		demo.doOtherThingWhileWaitFutureTask();
	}
}
