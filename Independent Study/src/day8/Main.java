package day8;

import java.util.*;
import java.util.function.*;

@FunctionalInterface
interface IntMaker {
	
	int make();
	
}

public class Main {
	
	public static void main(String[] args) {
		
		IntMaker a = () -> 3;
		
		IntMaker b = () -> 3;
		
		System.out.println(a.equals(b));
		
		ArrayList<Object> objs = new ArrayList<>();
		objs.add(new Object());
		objs.remove(new Object());
		
		ArrayList<IntMaker> makers = new ArrayList<>();
		IntMaker maker = () -> 7;
		makers.add(maker);
		makers.remove(maker);
		System.out.println(makers.size());
		
		Function<String, Integer> func = s -> s.length();
		
		Supplier<Double> rng = () -> Math.random();
		
		rng.get();
		
		Predicate<String> isLongString = s -> s.length() > 100;
		
		boolean baefefra = isLongString.test("efaefeaf");
		
		BiFunction<String, String, String> concatenator = (s1, s2) -> s1 + s2;
		BinaryOperator<String> concatenator2 = (s1, s2) -> s1 + s2;
	}
	
}
