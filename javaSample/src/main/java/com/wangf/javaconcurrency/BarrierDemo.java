package com.wangf.javaconcurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierDemo {
	private int WORKER_COUNT = 10;

	private void allWorkerDoneThenWholeTaskDone() {
		CyclicBarrier barrier = new CyclicBarrier(WORKER_COUNT,
				() -> System.out.println("All workers finish their jobs."));
		for (int i = 1; i <= WORKER_COUNT; i++) {
			Runnable job = () -> {
				int sleep = new Random().nextInt(5);
				try {
					// Sleep some time to mimic doing some work.
					Thread.sleep(sleep * 1000);
					System.out.println(Thread.currentThread().getName() + ": job of this worker done.");
					barrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};

			Thread worker = new Thread(job, "Thread" + i);
			worker.start();
		}
	}

	public static void main(String[] args) {
		new BarrierDemo().allWorkerDoneThenWholeTaskDone();
	}
}
