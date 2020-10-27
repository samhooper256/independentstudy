package day1;

import day2.Dog;

public class Assignments {
	
	public static void main(String[] args) {
		
		// What's happening here?
		int i = 3;	// identity
		double d = 1;	// widening primitive
		Object o1 = "hello";	// widening reference
		Integer eokoke = 3;	// boxing
		Object o = 12;	// boxing, widening reference
		int g = Integer.valueOf(77); // unboxing
		double q = Integer.valueOf(77); //unboxing, widening primitive
		Double n = null; // null
		String s;
		
		// Special cases:
		byte c = 66; 	
		Short z = 37;
		
		// These don't work:
//		String k = new Object();
//		Double m = 3;	
//		
//		byte r = 100 + 33;
//		
//		byte f = i; //i stores 3
		
		
	}
}
