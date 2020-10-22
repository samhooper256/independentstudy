package testingpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sam Hooper
 *
 */
public class FunctionalBarGraph {
	
	public static void main(String[] args) {
		System.out.println(stringFrom(lines(scanner(), emptyList())));
	}
	
	private static List<String> emptyList() {
		return new ArrayList<>();
	}
	private static Scanner scanner() {
		return new Scanner(System.in);
	}
	
	private static List<String> lines(Scanner in, List<String> list) {
		return handleLine(in, list, in.nextLine());
	}
	
	private static List<String> handleLine(Scanner in, List<String> list, String line) {
		return !line.equals("DONE") ? handleLine(in, add(list, line), in.nextLine()) : list;
	}
	
	public static String stringFrom(List<String> list) {
		return stringFrom(list, 0, getLongestSize(list));
	}
	
	private static int getLongestSize(List<String> list) {
		return getLongestSize(list, 0, 0);
	}
	
	private static int getLongestSize(List<String> list, int largestFound, int index) {
		return index == list.size() ? largestFound : getLongestSize(list, max(largestFound, list.get(index).length()), index + 1);
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static String stringFrom(List<String> list, int index, final int longestSize) {
		return index == list.size() ? "" : getBar(list.get(index), longestSize) + "\n" + stringFrom(list, index + 1, longestSize);
	}
	
	private static String format(String s, int size) {
		return s + " ".repeat(size - s.length());
	}
	
	public static String getBar(String input, int longestSize) {
		return getBar(input.split(" "), longestSize);
	}
	
	public static String getBar(String[] split, int longestSize) {
		return getBar(split[0], parse(split[1]), longestSize);
	}
	
	public static String getBar(String name, int length, int longestSize) {
		return format(name, longestSize) + " | " + "X".repeat(length);
	}
	
	public static int parse(String s) {
		return Integer.parseInt(s);
	}
	
	//this is cheating, technically...
	private static <T> List<T> add(List<T> list, T item) {
		list.add(item);
		return list;
	}
	
}
