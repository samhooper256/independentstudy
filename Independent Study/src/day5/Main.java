package day5;

import java.util.*;

import day1.Coin;

/* "Erasure" f(T) -> T
 * - Parameterized Type (G<T,S>) => Raw Type (G)
 * - Type Variable (T) => its leftmost bound
 * - T[] => an array of the erasure of T
 * - for all other types (X) => X.
 */

/*
 * m1 is a "subsignature" pf m2
 * - m1 is the same as m2
 * - m1 is the same as the erasure of m2
 */
public class Main extends Super {
	
	public static void main(String[] args) {
		Enum<Coin> coin = Coin.DIME;
		
		Testing.Nested n;
		Testing.StaticNested staticNested = new Testing.StaticNested();
	}
	
	void takeList() {
		
	}
	
	public void takeListString(List<String> l) {
		
	}
	
	public void takeList(List l) {
		
	}
	
}




class Super {
	public List<String> getList(Set<Integer> s) {
		return null;
	}
}