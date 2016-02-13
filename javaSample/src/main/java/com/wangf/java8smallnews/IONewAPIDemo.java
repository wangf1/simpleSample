package com.wangf.java8smallnews;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IONewAPIDemo {

	// 1. Use BufferedReader.lines() create a stream
	// 2. Files.lines(path)
	private void lineStream() throws IOException, URISyntaxException {
		URL url = getClass().getResource("demoFile.log");
		Path path = Paths.get(url.toURI());
		try (Stream<String> lines = Files.lines(path)) {
			lines.filter(line -> line.contains("2")).findFirst().ifPresent(System.out::println);
		}
	}

	private void readingDirectory() throws IOException {
		Path path = Paths.get(".");
		try (Stream<Path> stream = Files.list(path)) {
			stream.filter(p -> p.toFile().isFile()).forEach(System.out::println);
		}
		try (Stream<Path> stream = Files.walk(path, 2)) {
			stream.filter(p -> p.toFile().isDirectory()).forEach(System.out::println);
		}
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		IONewAPIDemo demo = new IONewAPIDemo();
		demo.lineStream();
		demo.readingDirectory();
	}

}
