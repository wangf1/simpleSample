package com.wangf.algorithms.sort;

import org.junit.Test;

import com.wangf.algorithms.sort.HeapSort;
import com.wangf.algorithms.sort.HeapSort.Heap;

public class HeapSortTest {
	private HeapSort heapSort = new HeapSort();
	private Heap heap = new Heap(new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 });
	private Heap heap2 = new Heap(new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 });

	private int heightOfIndex(int index) {
		double log2 = Math.log(index + 1) / Math.log(2);
		int heapHight = (int) Math.floor(log2) + 1;
		return heapHight;
	}

	private int heighOfHeap(int[] a) {
		return heightOfIndex(a.length);
	}

	/**
	 * TODO not yet figure out how to print a real good looking tree
	 * 
	 * @param a
	 */
	private void printHeap(int[] a) {
		int heapHight = heighOfHeap(a);
		for (int i = 0; i < heapHight; i++) {
			int begin = (int) Math.pow(2, i) - 2;
			int end = (int) Math.pow(2, i + 1) - 2;
			for (int j = begin + 1; j <= end; j++) {
				if (j < a.length) {
					System.out.print("***" + a[j] + "***");
				}
			}
			System.out.println();
		}
	}

	@Test
	public void testMaxHeapify() throws Exception {
		printHeap(heap.getHeapData());
		heapSort.maxHeapify(heap, 1);
		printHeap(heap.getHeapData());
	}

	@Test
	public void testbuildMaxHeap() throws Exception {
		printHeap(heap2.getHeapData());
		heapSort.buildMaxHeap(heap2);
		printHeap(heap2.getHeapData());
	}

	@Test
	public void testHeapSort() throws Exception {
		printHeap(heap2.getHeapData());
		heapSort.heapSort(heap2);
		printHeap(heap2.getHeapData());
	}
}