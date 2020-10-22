package testingpack;

import java.util.*;
import java.util.stream.*;

public class FunctionalBarGraph3 {
	
	public static void main(String[] args) {
		List<String[]> list = Stream.generate(new Scanner(System.in)::nextLine).takeWhile(line -> !line.equals("DONE"))
				.map(s -> s.split(" ")).collect(Collectors.toList());
		int maxLen = list.stream().mapToInt(s -> s[0].length()).max().getAsInt();
		list.stream().map(s -> String.format("%-" + maxLen + "s | %s", s[0], "X".repeat(Integer.parseInt(s[1]))))
				.forEach(System.out::println);
	}
	
}