package testingpack;

import java.util.*;
import java.util.stream.*;
/**
 * @author Sam Hooper
 *
 */
public class FunctionalBarGraph2 {
	
	public static void main(String[] args) {
		Stream.generate(new Scanner(System.in)::nextLine)
            .takeWhile(line -> !line.equals("DONE"))
            .map(s -> s.split(" "))
            .collect(
            	Collectors.teeing(
            		Collectors.maxBy((a, b) -> Integer.compare(a[0].length(), b[0].length())),
            		Collectors.mapping(x -> x, Collectors.toList()), 
            		(longestString, list) -> list.stream().map(
        				s -> s[0] + " ".repeat(longestString.get()[0].length() - s[0].length()) + " | " +
        				"X".repeat(Integer.parseInt(s[1]))
            		)
            	)
            ) 
            .forEach(System.out::println);
	}
	
}
