package testingpack;

import java.util.*;

/**
 * @author Sam Hooper
 *
 */
public class Test001 {
	public static void main(String[] args) {
		goo("");
		goo((Object) "");
		String s = "";
		goo(s);
		goo((Object) s);
		Object o = "";
		goo(o);
		
		var e = union(Set.of(1,2,3), Set.of(1.2));
		Number n;
		
		int x = 34;
		(x) = 3;
		
		int b = -128;
		System.out.println(b);
		System.out.println((int) ((char) b));
	}
	
	private static <E>  Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
		return null;
		
	} 
	
	public static void goo(String s) {
		System.out.printf("STRING%n");
	}
	
	public static void goo(Object o) {
		System.out.printf("OBJECT%n");
	}
}
