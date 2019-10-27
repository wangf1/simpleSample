package com.wangf.java8smallnews;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilesContentSearchWithJava8Features {

    public static void main(String[] args) throws IOException {
        new FilesContentSearchWithJava8Features().searchFileContent();
    }

    private void searchFileContent() throws IOException {
        List<String> filesWithMissingTestGroup = new ArrayList<>();
        List<String> filesWithBrokenTest = new ArrayList<>();

        Files.walk(Paths.get("/Users/i063078/git/workflow/au-workflow")).filter(path -> {
            boolean result = path.toString().endsWith("Test.java");
            return result;
        }).filter(path -> {
            try {
                return !Files.lines(path).anyMatch(s -> s.matches("^@Test.*"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }).forEach(path -> {
            try {
                List<String> linesOfTestAnnotation = Files.lines(path).filter(s -> s.matches(".*@Test.*")).collect(Collectors.toList());
                boolean noGroups = linesOfTestAnnotation.stream().anyMatch(s -> !s.matches(".*groups.*"));
                if (noGroups) {
                    filesWithMissingTestGroup.add(path.getFileName().toString());
                }
                boolean broken = linesOfTestAnnotation.stream().anyMatch(s -> s.matches(".*broken.*"));
                if (broken) {
                    filesWithBrokenTest.add(path.getFileName().toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("===========File missing test groups===========");
        filesWithMissingTestGroup.forEach(System.out::println);
        System.out.println("===========File with broken tests===========");
        filesWithBrokenTest.forEach(System.out::println);
    }
}
