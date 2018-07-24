package chapter4.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyFileReader1 {
	public static void main(String[] args) {
		List<String> fileNames = Arrays.asList(new String[]{"hello.txt","hello1.txt"});

		fileNames.stream().flatMap(
				fileName ->
				{
					try {
						return new BufferedReader(new FileReader(fileName)).lines();
					} catch (FileNotFoundException e) {
						//e.printStackTrace();
						return Stream.of(e.getMessage());
					}
				}
		).forEach(System.out::println);
	}
}
