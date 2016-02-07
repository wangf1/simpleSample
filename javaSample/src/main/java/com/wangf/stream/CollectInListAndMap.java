package com.wangf.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectInListAndMap {

	private List<Person> persons = Arrays.asList(new Person("p1", 10), new Person("p2", 20), new Person("n1", 21),
			new Person("n2", 21), new Person("n3", 22), new Person("m123", 23), new Person("m234", 40));

	private List<Person> persons2 = readPersonFromFile();

	private List<Person> readPersonFromFile() {
		List<Person> persons = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("persons.txt")));
				Stream<String> lines = reader.lines()) {
			lines.map(line -> {
				String[] array = line.split(" ");
				Person person = new Person(array[0], Integer.parseInt(array[1]));
				persons.add(person);
				return person;
			}).forEach(person -> System.out.println(person.getName() + ": " + person.getAge()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return persons;
	}

	private void collectInList() {
		String result = persons.stream().filter(person -> person.getAge() > 20).map(Person::getName)
				.collect(Collectors.joining(", "));
		System.out.println(result);

		Optional<Person> smallestBiggerThan20 = persons2.stream().filter(person -> person.getAge() > 20)
				.min(Comparator.comparing(Person::getAge));
		Person person = smallestBiggerThan20.get();
		System.out.println(person.getName() + ":" + person.getAge());
	}

	private void collectInMap() {
		Map<Integer, List<String>> result = persons.stream().filter(person -> person.getAge() > 20).collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		result.forEach((age, persons) -> {
			System.out.print(age + ":");
			persons.forEach(name -> {
				System.out.print(name + ", ");
			});
			System.out.println();
		});
	}

	public static void main(String[] args) {
		CollectInListAndMap demo = new CollectInListAndMap();
		demo.collectInList();
		demo.collectInMap();
	}
}
