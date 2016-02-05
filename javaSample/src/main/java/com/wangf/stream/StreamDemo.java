package com.wangf.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {

	private void predicateOnStream() {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		stream.filter(p1.and(p2.or(p3))).forEach(System.out::println);
		// peek demo
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		List<String> result = new ArrayList<>();
		list.stream().peek(System.out::println).filter(p1.and(p2.or(p3))).peek(result::add);
		System.out.println(
				"peek and filter method are not final operation, so the result size is 0 since the operation not actrually done: "
						+ result.size());
		list.stream().peek(System.out::println).filter(p1.and(p2.or(p3))).forEach(result::add);
		System.out.println(
				"forEach method is a final operation, so the actions are actrually done, the result list has elements:"
						+ result.size());
	}

	public static void main(String[] args) {
		StreamDemo demo = new StreamDemo();
		demo.predicateOnStream();
	}
}
