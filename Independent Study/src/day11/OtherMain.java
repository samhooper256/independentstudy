package day11;

import java.util.*;

public class OtherMain {
	
	public static void main(String[] args) {
		Optional<String> op = Optional.of("ea");
		op.isPresent();
		op.orElse("NOT PRESENT");
		
//		System.out.println(List.of("a","B").stream().findFirst().orElse("NOT PRESENT"));
		
		List.of("a","b").stream().findAny();
		
		List.of("a","b","c","d").stream().skip(2).forEachOrdered(System.out::println);
	
		List<String> strs = List.of("a","b3434","cea","","eee");
		
		System.out.println(strs.stream().reduce( (s1, s2) -> {
			if(s1.length() > s2.length())
				return s1;
			return s2;
		} ));
		
		System.out.println(strs.stream().reduce( (s1, s2) -> s1.length() > s2.length() ? s1 : s2));
		
		System.out.println(strs.stream().reduce((x, y) -> x + y));
		System.out.println(strs.stream().reduce("", (x, y) -> x + y));
		System.out.println(strs.stream().reduce(0, (i, s) -> i + s.length(), (x, y) -> x + y));
		
		System.out.println(strs.stream().mapToInt(s -> s.length()).sum());
		
		Set<String> result = strs.stream().reduce(new HashSet<>(), (set, str) -> {set.add(str); return set;}, (set1, set2) -> {
			set1.addAll(set2);
			return set1;
		});
		
		System.out.println(result);
		
	}
	
}