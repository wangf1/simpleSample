package com.wangf.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {
	private void fileFilterLambda() {
		FileFilter filter = (file) -> {
			boolean accept = file.getName().endsWith(".java");
			return accept;
		};
		File dir = new File("src/main/java/com/wangf/lambda");
		File[] files = dir.listFiles(filter);
		List<File> fileList = Arrays.asList(files);
		fileList.forEach((file) -> System.out.println(file.getAbsolutePath()));
	}

	private void functionalInterfaceDemo() {
		IAddSuffixFunctionalInterface func = (string) -> string + "_suffix";
		String withSuffix = func.addSuffix("origionalString");
		System.out.println(withSuffix);
	}

	private void consumerChain() {
		List<String> strings = Arrays.asList("s1", "s2", "s3");

		List<String> result = new ArrayList<>();

		Consumer<String> consumer1 = System.out::println;
		Consumer<String> consumer2 = (string) -> {
			String upper = string.toUpperCase();
			result.add(upper);
		};
		strings.forEach(consumer1.andThen(consumer2));
		result.forEach(consumer1);
	}

	public static void main(String[] args) {
		LambdaDemo demo = new LambdaDemo();
		demo.fileFilterLambda();
		demo.functionalInterfaceDemo();
		demo.consumerChain();
	}
}
