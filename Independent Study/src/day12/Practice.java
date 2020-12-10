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
	 * Q1: Given a Collection<String>, return the first String containing period ('.'), or null if no such String exists.
	 */
	public static String periodString(Collection<String> strs) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Q2: Given a double[], return a List<Long> containing the doubles rounded to the nearest long.
	 * 
	 * (Hint: Math.round(double) returns a long).
	 */
	public static List<Long> rounded(double[] nums) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Q3: Given an int[], return true if the smallest x unique ints in the given array are all less than y, false otherwise.
	 */
	public static boolean smallEnough(int[] nums, int x, int y) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Q4: Given a Collection<Double>, return the product of its elements as a double. Return 1.0 if it has one or fewer element(s).
	 */
	public static double product(Collection<Double> nums) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Q5 (EXTRA): Given a possibly infinite Stream<T>, return a "substream" between the given indices. That is, return a new Stream<T> containing
	 * the elements of the original Stream from startInclusive (inclusive) to endExclusive (exclusive). You can assume the indices are valid (they
	 * are both positive, they are less than the Stream's length if it is finite, and endExclusive > startInclusive). 
	 */
	public static <T> Stream<T> substream(Stream<T> stream, int startInclusive, int endExclusive) {
		throw new UnsupportedOperationException();
	}
	
	
}
