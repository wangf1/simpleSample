package com.wangf.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Sort {

	private int partition(Integer[] a, int start, int end) {
		// TODO check parameter for index out of range, etc
		int base = a[start];
		int i = start + 1;
		int j = end;
		while (i < j) {
			if (a[j] < base && a[i] > base) {
				swap(a, i, j);
			}
			if (a[j] > base) {
				j--;
			}
			if (a[i] <= base) {
				i++;
			}
		}
		if (base > a[j]) {
			swap(a, start, j);
		} else {
			swap(a, start, --j);
		}
		int partitionPosition = j;
		return partitionPosition;
	}

	private void swap(Integer[] a, int i, int j) {
		int aiBkup = a[i];
		a[i] = a[j];
		a[j] = aiBkup;
	}

	private void quickSort(Integer[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int position = partition(a, start, a.length - 1);
		quickSort(a, start, position - 1);
		quickSort(a, position + 1, end);
	}

	@Test
	public void testPartition() throws Exception {
		Integer[] a = new Integer[] { 5, 1, 3, 8, 9, 2, 4, 7, 6 };
		testPartition(a);

		Integer[] a2 = new Integer[] { 5, 1, 3, 8, 9, 3, 2, 4, 7, 6 };
		testPartition(a2);
	}

	private void testPartition(Integer[] a) {
		int base = a[0];
		int position = partition(a, 0, a.length - 1);
		System.out.println(Arrays.asList(a));
		System.out.println(position);
		assertEquals(a[position].intValue(), base);
	}

	@Test
	public void testQuickSort() throws Exception {
		Integer[] a = new Integer[] { 5, 1, 3, 8, 9, 2, 4, 7, 6 };
		testQuickSort(a);

		Integer[] a2 = new Integer[] { 5, 1, 3, 8, 9, 3, 2, 4, 7, 6 };
		testQuickSort(a2);
	}

	private void testQuickSort(Integer[] a) {
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.asList(a));
	}
}
