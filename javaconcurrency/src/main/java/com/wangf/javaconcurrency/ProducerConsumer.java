package com.wangf.javaconcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	private static final int MAX_PRODUCT = 10;
	private final BlockingQueue<String> productQueue = new LinkedBlockingQueue<>();

	private static class Producer implements Runnable {

		private final BlockingQueue<String> queue;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			for (int i = 0; i < MAX_PRODUCT; i++) {
				try {
					String product = "Product" + i;
					queue.put(product);
					System.out.println("++++Produced " + product);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static class Consumer implements Runnable {
		private final BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				for (int i = 0; i < MAX_PRODUCT * 2; i++) {
					String product = queue.take();
					System.out.println("----Consumed " + (i + 1) + " products: " + product);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void startWork() {
		Producer producer = new Producer(productQueue);
		new Thread(producer).start();

		Producer producer2 = new Producer(productQueue);
		new Thread(producer2).start();

		Consumer Consumer = new Consumer(productQueue);
		new Thread(Consumer).start();
	}

	public static void main(String[] args) {
		new ProducerConsumer().startWork();
	}
}