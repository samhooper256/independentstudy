package day6;

import java.util.*;

public class FilterMain {
	
	public static void main(String[] args) {
		List<String> filtered = filter(List.of("a","b","cce","eafeafA"), s -> s.length() < 3); //produces ["a", "b"]
		List<Integer> filtered2 = filter(List.of(1, 2, 3, 4, 5), x -> x % 2 == 0); //produces [2, 4]

		System.out.println(filtered);
		System.out.println(filtered2);
	}
	
	public static <T> List<T> filter(List<T> list, Filterer<? super T> filterer) {
		ArrayList<T> filtered = new ArrayList<>();
		for(T item : list)
			if(filterer.satisfies(item))
				filtered.add(item);
		return filtered;
	}
}
