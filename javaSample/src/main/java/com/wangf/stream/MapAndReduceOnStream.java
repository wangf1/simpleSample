package com.wangf.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapAndReduceOnStream {

	private void mapAndFlatMap() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		List<Integer> list3 = Arrays.asList(3, 5, 7);

		List<List<Integer>> list = Arrays.asList(list1, list2, list3);

		Function<List<?>, Integer> size = List::size;

		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

		list.stream().map(size).forEach(System.out::println);

		list.stream().map(flatMapper).forEach(System.out::println);
		list.stream().flatMap(flatMapper).forEach(System.out::println);
	}

	private void reduce() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		BinaryOperator<Integer> sum = (i, j) -> i + j;
		Integer identity = 0;
		int sumResult = list.stream().reduce(identity, sum);
		System.out.println(sumResult);

		BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;
		Integer maxResult = list.stream().reduce(0, max);
		System.out.println(maxResult);

		Optional<Integer> maxResult2 = list.stream().max(Comparator.naturalOrder());
		System.out.println(maxResult2.get());

		List<Person> persons = Arrays.asList(new Person("p1", 10), new Person("p2", 20), new Person("n1", 21),
				new Person("n2", 22), new Person("m123", 23), new Person("m234", 40));
		Optional<Integer> minAgeBiggerThan20 = persons.stream().map(person -> person.getAge()).filter(age -> age > 20)
				.min(Comparator.naturalOrder());
		System.out.println(minAgeBiggerThan20.get());

		boolean allNameLongerThan3ContainsM = persons.stream().map(person -> person.getName())
				.filter(name -> name.length() >= 3).allMatch(name -> name.contains("m"));
		System.out.println(allNameLongerThan3ContainsM);

		Optional<Integer> maxResult3 = list.stream().reduce(Integer::max);
		System.out.println(maxResult3.get());
	}

	public static void main(String[] args) {
		MapAndReduceOnStream demo = new MapAndReduceOnStream();
		demo.mapAndFlatMap();
		demo.reduce();
	}

}
