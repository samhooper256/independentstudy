package day13;

import java.util.*;
import java.util.stream.*;

public class Main {
	
	public static void main(String[] args) {
		List<String> strs = List.of("a","banana","cat");
		List<Integer> integers = List.of(1,2,3);
		
		String concat = strs.stream().collect(Collectors.joining());
		String concat2 = strs.stream().collect(Collectors.joining(", "));
		String concat3 = strs.stream().collect(Collectors.joining(", ", "{", "}"));
		
		System.out.println(concat3);
		
		// groupingBy and partioningBy
		
		Map<Boolean, List<String>> partition1 = strs.stream().collect(Collectors.partitioningBy(s -> s.length() >= 3));
		Map<Boolean, Set<String>> partition2 = strs.stream().collect(Collectors.partitioningBy(s -> s.length() >= 3, Collectors.toSet()));
		
		System.out.println(partition2);
		
		State tx = new State("Texas", null);
		State michigan = new State("Michigan", null);
		
		List<City> cities = List.of(new City("Dallas", tx, 0) , new City("Detriot", michigan, 0), new City("Austin", tx, 0));
		
		System.out.println(cities);
		
		Map<State, List<City>> cityMap = cities.stream().collect(Collectors.groupingBy(city -> city.getState()));
		
		System.out.println(cityMap);
		
	}
	
}
