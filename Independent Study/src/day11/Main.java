package day11;

import java.util.*;
import java.util.stream.*;

public class Main {
	
	public static void main(String[] args) {
		Arrays.stream(new String[] {"a","b"}); //Stream<String>
		IntStream intStream = Arrays.stream(new int[] {1,2,3}); //IntStream
		
		Stream<Integer> boxed = intStream.boxed();
	
		IntStream is2 = boxed.mapToInt(x -> x.intValue());
		
		IntStream lens = Stream.of("a","b","c").mapToInt(s -> s.length());
		
		List<String> strs = List.of("def","abc","gh","abc","z","abc");
		
		strs.stream().distinct().forEachOrdered(System.out::println);
		
		strs.stream().sorted().forEachOrdered(System.out::println);
		
		strs.stream().forEach(System.out::println);
		
		strs.stream().forEachOrdered(System.out::println);
		
		Set<String> set = new HashSet<>();
		Collections.addAll(set, "a","x","p","z");
		System.out.println(set);
		System.out.println();
		set.stream().forEach(System.out::println);
		System.out.println();
		set.stream().forEachOrdered(System.out::println);
		
		
	}
	
}
