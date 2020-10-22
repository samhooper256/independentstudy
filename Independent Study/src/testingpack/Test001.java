package testingpack;

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
	}
	
	public static void goo(String s) {
		System.out.printf("STRING%n");
	}
	
	public static void goo(Object o) {
		System.out.printf("OBJECT%n");
	}
}
