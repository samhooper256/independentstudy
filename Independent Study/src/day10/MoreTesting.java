package day10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreTesting {
	
	public static void main(String[] args) {
		List<String> strs = new ArrayList<>();
		strs.add("cat");
		strs.add("dog");
		strs.add("house");
		
		String[] uppercased = strs.stream().map(String::toUpperCase).toArray(String[]::new);
		
		System.out.println(Arrays.toString(uppercased));
		
		ArrayList<Integer> lengths = strs.stream().map(s -> s.length()).collect(Collectors.toCollection(ArrayList::new));
		
		System.out.println(lengths);
		
		Map<String, Integer> map = strs.stream().collect(Collectors.toMap(Function.identity(), String::length));
		
		System.out.println(map);
	
		System.out.println(strs.stream().allMatch(s -> s.length() < 4));
		System.out.println(strs.stream().noneMatch(s -> s.startsWith("p")));
		System.out.println(strs.stream().anyMatch(s -> s.startsWith("c")));
		
		System.out.println(strs.stream().count());
		
		
	}
	
}
