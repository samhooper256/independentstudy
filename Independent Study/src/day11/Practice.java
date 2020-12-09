package day11;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
/**
 * @author Sam Hooper
 *
 */
public class Practice {
	
	public static void main(String[] args) {
		
	}
	
	//PRACTICE PROBLEMS
	
	/* Q1: Given a double[], return its sum. */
	public static double sum(final double[] arr) {
		return Arrays.stream(arr).sum();
	}
	
	 /* Q2: Return an array of 'size' random doubles, each between 0 (inclusive) and 1.0 (exclusive). */
	public static double[] randoms(final int size) {
//		return Stream.generate(Math::random).limit(size).toArray(Double[]::new); //for Double[]
		return DoubleStream.generate(Math::random).limit(size).toArray(); //for double[]
//		return new Random().doubles(size).toArray(); //for double[]
	}
	
	/* Q3: Given a Set<Integer>, return a Map<Integer, Integer> that maps each Integer in the original set to its square. */
	public static Map<Integer, Integer> squareMap(final Set<Integer> nums) {
		return nums.stream().collect(Collectors.toMap(x -> x, x -> x * x));
	}
	
	/* Q4: Given a Collection<String>, return a Set<String> containing the first characters of each String in the given Collection.
	  * The Strings in the returned set should all have length 1.
	  * 
	  * Ex: firstChars(List.of("apple","banana","avocado","car")) returns a set containing [a, b, c].
	  * 
	  * The given Collection may contain empty Strings - make sure to ignore those!
	  * */
	public static Set<String> firstChars(final Collection<String> strs) {
		return strs.stream().filter(s -> !s.isEmpty()).map(s -> s.substring(0, 1)).collect(Collectors.toSet());
	}
	
	/* Q5 ("Extra"): Given an int[], return a long[] containing the same values. */
	public static long[] toLongs(final int[] arr) {
		throw new UnsupportedOperationException();
	}
	
}
