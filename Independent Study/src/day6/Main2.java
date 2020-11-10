package day6;

import java.util.Arrays;
import java.util.List;

public class Main2 {
	
	//Takes a List, and filters out elements according to some boolean function. Returns a new list containing only the
	//elements that satisfied the condition.
	
	
	public static void main(String[] args) {
		
		//examples:
//		List<String> filtered = filter(List.of("a","b","cce","eafeafA"), s -> s.length() < 3); //produces ["a", "b"]
//		List<Integer> filtered2 = filter(List.of(1, 2, 3, 4, 5), x -> x % 2 == 0); //produces [2, 4]
		
		
		
		
		Mapper<String> stringMapper = s -> s + "!";
		String[] messages = {"dog", "cat", "bag", "oof"};
		map(messages, stringMapper);
		System.out.println(Arrays.toString(messages));
		
		map(messages, s -> s.toUpperCase());
		System.out.println(Arrays.toString(messages));
		
		Integer[] nums = {1,2,4,6,3,4};
		map(nums, x -> x * 2);
		System.out.println(Arrays.toString(nums));
		
	}
	
	
	
	public static <T> void map(T[] arr, Mapper<T> mapper) {
		for(int i = 0; i < arr.length; i++)
			arr[i] = mapper.map(arr[i]);
	}
}

@FunctionalInterface
interface Mapper<T> {
	T map(T arg);
}

interface Inter {
	<S> S get();
}