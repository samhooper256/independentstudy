package day9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

public class Examples {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		
		list.add("aeaf");
//		list.add("   \n \n");
		list.add("ea");
//		list.add("");
		list.add("eafeafef");
		
//		String[] arr = list.toArray();
		String[] arr = list.toArray(String[]::new);
		
//		list.forEach(str -> System.out.println(str));
		
//		list.removeIf(str -> str.length() > 3);
		
//		list.removeIf("ea"::equals);
		
//		list.removeIf(String::isEmpty);
		
//		list.forEach(System.out::println);
		
		list.replaceAll(str -> str + "!");
		
		list.replaceAll(String::toUpperCase);
		
		list.forEach(System.out::println);
		
		IntFunction<String> ex = "eaf"::substring;
		
		BiFunction<Integer, Integer, String> ex2 = "eaf"::substring;
		
		
		
	}
	
}
