package day10;

import java.util.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
	
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "abc","def","ghi","jklm");
		
		list.stream();
		
		int[] arr = {1,5,2,6};
		
		IntStream stream = Arrays.stream(arr);
		
//		System.out.println(stream.sum());
		
		String[] strArr = {"a","abeab","090A","hefee"};
		
		Stream<String> strStream = Arrays.stream(strArr);
		
//		strStream.forEach(System.out::println);
		
		strStream
			.map(str -> str.toUpperCase())
			.findFirst();
		
//		System.out.println(Arrays.toString(strArr));
		
//		System.out.println(Stream.generate(() -> 4).findFirst());
		
//		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
//		"Hello".chars().forEach(x -> System.out.println((char) x));
//		"aef\naef\naef".lines().forEach(System.out::println);
		
//		IntStream.range(0, 100).map(x -> x * x).forEach(System.out::println);
		
		Random r = new Random();
		
		r.ints(50, 0, 100).forEach(System.out::println);
	}
	
}
