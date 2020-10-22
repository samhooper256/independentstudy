package testingpack;

import java.util.Scanner;

/**
 * @author Sam Hooper
 *
 */
public class FunctionalBarGraph4 {
	
	public static void main(String[] args) {
		System.out.println(from(lines(scanner())));
	}
	
	private static Scanner scanner() {
		return new Scanner(System.in);
	}
	
	private static String[] lines(Scanner in) {
		return in.findWithinHorizon("(?s).*?(?=DONE)", 0).split("[\n\r]+");
	}
	
	private static String from(String[] lines) {
		return from(lines, new StringBuilder(), 0, longestLength(lines));
	}
	
	private static String from(String[] lines, StringBuilder builder, int index, int maxLen) {
		return index == lines.length ?
				builder.toString() :
				from(lines, builder.append(fromLine(lines[index].split(" "), maxLen)).append('\n'), index + 1, maxLen);
	}
	
	private static String fromLine(String[] parts, int maxLen) {
		return format(parts[0], maxLen) + " | " + "X".repeat(parse(parts[1]));
	}
	
	private static int longestLength(String[] lines) {
		return longestSize(lines, 0, 0);
	}
	
	private static int longestSize(String[] lines, int largestFound, int index) {
		return index == lines.length ? largestFound : longestSize(lines, max(largestFound, lines[index].indexOf(' ')), index + 1);
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	private static String format(String s, int size) {
		return s + " ".repeat(size - s.length());
	}
	
	private static int parse(String s) {
		return Integer.parseInt(s);
	}
	
}
