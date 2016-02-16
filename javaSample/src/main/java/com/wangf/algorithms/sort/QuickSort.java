package com.wangf.algorithms.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort {

	private int partition(int[] a, int start, int end) {
		// TODO check parameter for index out of range, etc
		int base = a[start];
		int i = start + 1;
		int j = end;
		while (i < j) {
			if (a[j] < base && a[i] > base) {
				Utils.swap(a, i, j);
			}
			if (a[j] > base) {
				j--;
			}
			if (a[i] <= base) {
				i++;
			}
		}
		if (base > a[j]) {
			Utils.swap(a, start, j);
		} else {
			Utils.swap(a, start, --j);
		}
		int partitionPosition = j;
		return partitionPosition;
	}

	private void quickSort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int position = partition(a, start, a.length - 1);
		quickSort(a, start, position - 1);
		quickSort(a, position + 1, end);
	}

	// ==========Begin test code===========
	@Test
	public void testPartition() throws Exception {
		int[] a = new int[] { 5, 1, 3, 8, 9, 2, 4, 7, 6 };
		testPartition(a);

		int[] a2 = new int[] { 5, 1, 3, 8, 9, 3, 2, 4, 7, 6 };
		testPartition(a2);
	}

	private void testPartition(int[] a) {
		int base = a[0];
		int position = partition(a, 0, a.length - 1);
		Utils.print(a);
		System.out.println(position);
		assertEquals(a[position], base);
	}

	@Test
	public void testQuickSort() throws Exception {
		int[] a = new int[] { 5, 1, 3, 8, 9, 2, 4, 7, 6 };
		testQuickSort(a);

		int[] a2 = new int[] { 5, 1, 3, 8, 9, 3, 2, 4, 7, 6 };
		testQuickSort(a2);
	}

	private void testQuickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
		Utils.print(a);
	}
}
