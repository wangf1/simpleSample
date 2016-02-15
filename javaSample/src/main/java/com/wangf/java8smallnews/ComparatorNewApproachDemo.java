package com.wangf.java8smallnews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.wangf.stream.Person;

public class ComparatorNewApproachDemo {

	private void createComparatorNewWay() {

		List<Person> persons = Arrays.asList(new Person("p1", 30), null, new Person("p1", 20), new Person("n1", 21),
				new Person("n2", 22), new Person("m123", 23), new Person("m234", 40));
		System.out.println(persons);

		Comparator<Person> compareNameThenAge = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
		Comparator<Person> nullFirstCompareNameAge = Comparator.nullsFirst(compareNameThenAge);
		persons.sort(nullFirstCompareNameAge);
		System.out.println(persons);

		Comparator<Person> reversed = nullFirstCompareNameAge.reversed();
		persons.sort(reversed);
		System.out.println(persons);
	}

	public static void main(String[] args) {
		ComparatorNewApproachDemo demo = new ComparatorNewApproachDemo();
		demo.createComparatorNewWay();
	}
}
