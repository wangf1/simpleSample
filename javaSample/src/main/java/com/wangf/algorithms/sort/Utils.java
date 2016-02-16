package com.wangf.algorithms.sort;

import java.util.StringJoiner;

public class Utils {
	public static void swap(int[] a, int i, int j) {
		int aiBkup = a[i];
		a[i] = a[j];
		a[j] = aiBkup;
	}

	public static void print(int[] a) {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		for (int i = 0; i < a.length; i++) {
			sj.add(String.valueOf(a[i]));
		}
		System.out.println(sj.toString());
	}
}
