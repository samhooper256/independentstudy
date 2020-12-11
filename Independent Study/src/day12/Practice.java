package day12;

import java.util.*;
import java.util.stream.*;

/**
 * @author Sam Hooper
 *
 */
public class Practice {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Q1: Given a List<String>, return the first String in the List that contains a period ('.'), or null if no such
	 * String exists.
	 */
	public static String periodString(List<String> strs) {
		return strs.stream().filter(s -> s.contains(".")).findFirst().orElse(null);
	}
	
	/*
	 * Q2: Given a double[], return a List<Long> containing the doubles rounded to the nearest long.
	 * The Longs in the List should be in the same order as their unrounded counterparts in the array.
	 * 
	 * (Hint: Math.round(double) returns a long).
	 */
	public static List<Long> rounded(double[] nums) {
		return Arrays.stream(nums).mapToLong(Math::round).boxed().collect(Collectors.toList());
//		return Arrays.stream(nums).boxed().map(n -> Math.round(n)).collect(Collectors.toList());
	}
	
	/*
	 * Q3: Given an int[], return true if the smallest x unique ints in the given array are all less than y, false otherwise.
	 */
	public static boolean smallEnough(int[] nums, int x, int y) {
		return Arrays.stream(nums).distinct().sorted().limit(x).allMatch(i -> i < y);
//		return Arrays.stream(nums).distinct().filter(i -> i < y).count() <= x;
	}
	
	/*
	 * Q4: Given a Collection<Double>, return the product of its elements as a double. Return 1.0 if it no elements.
	 */
	public static double product(Collection<Double> nums) {
		return nums.stream().reduce(1.0, (a, b) -> a * b);
//		return nums.stream().mapToDouble(d -> d.doubleValue()).reduce(1.0, (a,b) -> a * b);
	}
	
	/*
	 * Q5 (EXTRA): Given a possibly infinite Stream<T>, return a "substream" between the given indices. That is, return a new Stream<T> containing
	 * the elements of the original Stream from startInclusive (inclusive) to endExclusive (exclusive). You can assume the indices are valid (they
	 * are both positive, they are less than the Stream's length if it is finite, and endExclusive > startInclusive). 
	 */
	public static <T> Stream<T> substream(Stream<T> stream, int startInclusive, int endExclusive) {
		return stream.skip(startInclusive).limit(endExclusive - startInclusive);
	}
	
}
