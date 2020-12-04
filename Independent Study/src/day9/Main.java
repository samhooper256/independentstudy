package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
	
	interface Func {
		double apply(double x);
	}
	
	public static void main(String[] args) {
		List<String> strs = List.of("abc", "234a", " 0zz", "aefaf", "E", "aeQ~", "p");
		
		Func f = Math::sqrt;
		
		System.out.println(f.apply(16));
		
		String s = "+-/*";
		
		Predicate<String> pred = s::contains;
		
		
		System.out.println(pred.test("a"));
		
		Supplier<Object> supplier = Object::new;
		
		Object b = supplier.get();
		
		
		Function<String, Integer> len = String::length;
		
		System.out.println(len.apply("abc"));
		
		BiFunction<String, String, Integer> indexOf = String::indexOf;

		System.out.println(indexOf.apply("cat", "a"));
		
		Supplier<List<String>> listMaker = ArrayList::new;
		
		List<String> strs2 = listMaker.get();
		
		Function<Integer, String[]> function = String[]::new;
	
		System.out.println(Arrays.toString(function.apply(4)));
	}
	
}
