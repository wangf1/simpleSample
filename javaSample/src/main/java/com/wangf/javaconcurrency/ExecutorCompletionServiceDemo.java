package com.wangf.javaconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceDemo {
	private void getResultWhenItIsAvailable() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
		for (int i = 0; i < 10; i++) {
			int j = i;
			Callable<String> task = () -> {
				Thread.sleep(1000);
				String taskName = Thread.currentThread().getName() + ": " + j;
				return taskName;
			};
			completionService.submit(task);
		}

		executor.shutdown();

		for (int i = 0; i < 10; i++) {
			Future<String> future = completionService.take();
			String taskName = future.get();
			System.out.println("Task done: " + taskName);
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorCompletionServiceDemo demo = new ExecutorCompletionServiceDemo();
		demo.getResultWhenItIsAvailable();
	}
}
