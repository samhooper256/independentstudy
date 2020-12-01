package day8;

import java.util.*;
import java.util.function.*;

public class Practice {
	
	public static void main(String[] args) {
		
		Collection<String> strs = Set.of("a","ceafeaf","eafea");
		List<Collection<String>> fork = fork(strs, s -> s.length() > 4);
		System.out.println(fork);
		Predicate<Object> nonNull = o -> o != null;
		fork(strs, nonNull);
		
	}
	
	public static <T> List<Collection<T>> fork(Collection<T> coll, Predicate<? super T> condition) {
		Collection<T> trues = new ArrayList<>(), falses = new ArrayList<>();
		for(T item : coll)
			if(condition.test(item))
				trues.add(item);
			else
				falses.add(item);
		return List.of(trues, falses);
	}
	
	//Write a method called "fork" that takes a Collection and a boolean-valued function and returns two
	//new Collections: the first containing all the elements that satisfy the function, and the second containing
	//all the elements that don't satisfy the function.
}
