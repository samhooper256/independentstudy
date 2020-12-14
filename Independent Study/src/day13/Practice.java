package day13;

import java.util.*;
import java.util.stream.*;

/**
 * @author Sam Hooper
 *
 */
public class Practice {
	
	public static void main(String[] args) {
		System.out.println(lastDigitSorted(new int[]{17,102,88,0}));
		System.out.println(maxCharacterSum(List.of("car", "boy", "yam", "axe")));
	}
	
	/* Q1: Return the shortest String in the given Set<String> that does not contain any spaces (' '), or null if no such String exists. */ 
	public static String shortestSpaceless(Set<String> strs) {
		throw new UnsupportedOperationException();
	}
	
	/* Q2: Given an int[], return a List<Integer> containing the elements in the int[] sorted by their last digit (in increasing order).
	 * For example, lastDigitSorted(new int[]{17,102,88,0}) returns a List<Integer> containing [0, 102, 17, 88].
	 * You can assume there are no negatives in the int[] and that 0 has a last digit of 0. If two numbers have the same
	 * last digit, they may appear in any order relative to one another in the returned List. (In other words, the sort need not be stable).
	 */
	public static List<Integer> lastDigitSorted(int[] arr) {
		throw new UnsupportedOperationException();
	}
	
	/* Q3: Given a List<String>, return a StringBuilder storing all the Strings in the List concatenated to one another, in order.
	 * For example, concat(List.of("a", "b", "c")) returns a StringBuilder whose toString() returns "abc".
	 * Reminders:
	 * 	  -	The method append(CharSequence) on StringBuilders adds the given CharSequence to the StringBuilder's contents. The method also returns the StringBuilder
	 * 		it was called from (In other words, the method body ends with "return this;")
	 *    - The toString() method of a StringBuilder returns its contents. For example, new StringBuilder().append("le").append("t").toString() returns "let".
	 */
	public static StringBuilder concat(List<String> strs) {
		throw new UnsupportedOperationException();
	}
	
	/* Q4 (EXTRA): Given a Collection<String>, return the String where the sum of its characters' int values is maximal. If multiple Strings tie for the
	 * maximum sum, you may return any one of them. You can assume the Collection is non-empty.
	 *		
	 *		For example,
	 *		maxCharacterSum(List.of("a", "z", "m")) returns "z" since ((int) 'a')=97, ((int) 'z')=122, and ((int) 'm')=109.
	 *		maxCharacterSum(Set.of("car", "boy", "yam", "axe")) returns "boy"
	 *			since the sums are:
	 *				"car" = ((int) 'c') + ((int) 'a') + ((int) 'r') = 99 + 97 + 114 = 310
	 *				"boy" = 98  + 111 + 121 = 330
	 *				"yam" = 121 + 97  + 109 = 327
	 *				"axe" = 97  + 120 + 101 = 318
	 */
	public static String maxCharacterSum(final Collection<String> strs) {
		throw new UnsupportedOperationException();
	}
	
}
