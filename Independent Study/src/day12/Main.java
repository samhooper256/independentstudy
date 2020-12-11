package day12;

import java.util.*;
import java.util.stream.*;

public class Main {
	
	public static void main(String[] args) {
		Comparable<?> c;
		Comparator<String> comparator;
		
		String[] arr = {"abc","zek", "ok", "aeokoaf", "___"};
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, Comparator.comparingInt(String::length));
		
		System.out.println(Arrays.toString(arr));
		
		List<String> strs = List.of("a","b","ceaf","eaf","okeofkef");
		
		strs.stream().sorted(Comparator.comparingInt(String::length)).forEachOrdered(System.out::println);
		
		strs.stream().min(Comparator.naturalOrder());
		
		System.out.println(strs.stream().takeWhile(s -> s.length() < 2).collect(Collectors.toList()));
		System.out.println(strs.stream().dropWhile(s -> s.length() < 2).collect(Collectors.toList()));
		
		//Collectors
		
		Arrays.stream(arr).collect(Collector.of(ArrayList::new, ArrayList::add, (list1, list2) -> {list1.add(list2); return list1;}));
		
	}
	
}
