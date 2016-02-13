package com.wangf.java8smallnews;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StringNewFeatureDemo {
	private void stringIntStream() {
		String helloWorld = "Hello" + " " + "world!";
		IntStream stream = helloWorld.chars();
		stream.map((i) -> {
			char c = (char) i;
			char upper = Character.toUpperCase(c);
			return upper;
		}).forEach((i) -> {
			char c = (char) i;
			System.out.print(c);
		});
		System.out.println();
	}

	private void stringJoinerDemo() {
		StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.add("1").add("2").add("3");
		System.out.println(sj.toString());

		String joined = String.join(", ", new String[] { "one", "two", "three" });
		System.out.println(joined);
	}

	public static void main(String[] args) {
		StringNewFeatureDemo demo = new StringNewFeatureDemo();
		demo.stringIntStream();
		demo.stringJoinerDemo();
	}
}
