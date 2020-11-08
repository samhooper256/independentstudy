package day5;

import java.util.Map;

// Nested Types

/*
 * Types of member types:
 *	- (static) interfaces
 *  - non-static class
 *  - static class
 */
public class Testing {
	
	private static String staticVar = "";
	private int x;
	
	public interface Face {
		
	}
	
	public class Nested {
		
	}
	
	static class StaticNested {
		static String str = staticVar;
	}
	
	public void instanceMethod() {
		
	}
	
	
	public static void main(String[] args) {
		Testing t = new Testing();
		//Non-static member type: needs to be created from an instance of the enclosing type
		Nested n = t.new Nested();
		
		Map.Entry<String, Integer> entry;
		
		//anonymous class
		Object o = new Object() {
			int x;
			//instance initializer: gets executed AFTER the superclass (Object's) constructor finished.
			//We can't make a constructor in an anonymous class (because the class has no name), so this is how
			//we do any intance initialization we need to do.
			{
				x = 5;
			}
			
			@Override
			public String toString() {
				return "Anonymous[" + x + "]";
			}
			
			//we can't call this method from the outside world because this class doesn't have a name,
			//and its sole instance is stored in a variable of type Object.
			public void method() {
				
			}
		};
		
		//Local class - can only be used in this (the main) method, and can only be used after it is declared.
		class Local {
			public Local() {
				Object p = o;
			}
		}
		
		Local l = new Local();
		System.out.println(o);
	}
	
	public void instance() {
		//another local class. Note how it can refer to variables of Testing instance (the "x" variable).
		class Local {
			public Local() {
				int zz = x;
			}
		}
	}
}
