package day10;

import java.io.IOException;
import java.nio.file.*;

public class FileTester {
	
	public static void main(String[] args) throws Exception {
		Files.lines(Path.of("src/day10/input.txt")).forEach(System.out::println);
	}
	
}
