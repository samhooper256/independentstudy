package day1;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class FunctionalBarGraph2 {
	
	public static void main(String[] args) {
		Stream.generate(new Scanner(System.in)::nextLine)
            .takeWhile(line -> !"DONE".equals(line))
            .map(s -> s.split(" "))
            .collect(
            	teeing(
            		collectingAndThen(mapping(a -> a[0].length(), maxBy(Comparator.naturalOrder())), Optional::get),
            		toList(), 
            		(longestLength, list) -> list.stream().map(
        				s -> String.format("%-" + (longestLength - s[0].length() + 1) + "s | %s", s[0], "X".repeat(Integer.parseInt(s[1])))
            		)
            	)
            ) 
            .forEachOrdered(System.out::println);
	}
	
}
