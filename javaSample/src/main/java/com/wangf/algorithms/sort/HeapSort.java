package com.wangf.algorithms.sort;

public class HeapSort {

	private int parentIndex(int index) {
		int parent = (int) Math.ceil(index / 2) - 1;
		return parent;
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	public void maxHeapify(Heap heap, int i) {
		int left = leftChildIndex(i);
		int right = rightChildIndex(i);
		int largestIndex;
		if (left < heap.getHeapSize() && heap.getElement(left) > heap.getElement(i)) {
			largestIndex = left;
		} else {
			largestIndex = i;
		}
		if (right < heap.getHeapSize() && heap.getElement(right) > heap.getElement(largestIndex)) {
			largestIndex = right;
		}
		if (largestIndex != i) {
			Utils.swap(heap.getHeapData(), largestIndex, i);
			maxHeapify(heap, largestIndex);
		}
	}

	public void buildMaxHeap(Heap heap) {
		int lastNonLeafNodeIndex = lastNonLeafNodeIndex(heap.getHeapData());
		for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
			maxHeapify(heap, i);
		}
	}

	private int lastNonLeafNodeIndex(int[] heap) {
		int index = (heap.length - 1) / 2;
		return index;
	}

	public void heapSort(Heap heap) {
		buildMaxHeap(heap);
		for (int i = heap.getHeapData().length - 1; i >= 1; i--) {
			Utils.swap(heap.getHeapData(), i, 0);
			int newHeapSize = heap.getHeapSize() - 1;
			heap.setHeapSize(newHeapSize);
			maxHeapify(heap, 0);
		}
	}

	public static class Heap {
		private int heapSize;
		private int[] heapData;

		public Heap(int[] heapData) {
			this.heapData = heapData;
			this.heapSize = heapData.length;
		}

		public int getHeapSize() {
			return heapSize;
		}

		public void setHeapSize(int heapSize) {
			this.heapSize = heapSize;
		}

		public int[] getHeapData() {
			return heapData;
		}

		public void setHeapData(int[] heapData) {
			this.heapData = heapData;
		}

		public int getElement(int index) {
			int element = heapData[index];
			return element;
		}
	}
}
