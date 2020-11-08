package day5;

import java.util.*;

// Types of methods you can make in an interface:
/* - abstract methods (all public)
 * - static methods (private or public)
 * - default methods
 * - private conrete methods
 * 
 * Fields in interfaces:
 * - all must be public, static, and final
 */
public interface Flammable extends Thing, Inter {
	
	int BURN_TIME = 20;
	
	void ignite();
	
	default void method() {
		System.out.println("Defualt method");
	}
	
	private void concrete() {
		
	}
	
	public static void burn(Flammable o) {
		o.ignite();
		Collection<String> strs;
	}
	
	void add(Object o);
	
	default void addAll(Object... objects) {
		for(Object o : objects)
			add(o);
	}
}

interface Thing {
	
}

interface Inter{
	
}