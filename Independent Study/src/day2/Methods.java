package day2;

import java.util.*;

import day1.Coin;

public class Methods {
	
	
	public static void main(String[] args) {
	
		ArrayList<String> strs = new ArrayList<>();
		ArrayList<Integer> ints = new ArrayList<>();
		System.out.println(strs.getClass() == ints.getClass()); //true
		
		Object o = "hello";
		Dog d = new Dog();
		String x = d.name;
		int hp = d.health;
		
		Coin c; //can't use Coin from other package (unless I import)
		
		
//		Pair<String, Integer> pair1 = new Pair<>("ab", 3);
//		System.out.println(pair1);
//		Pair<Double, String> pair2 = new Pair<>(2.3, "goof");
//		System.out.println(Pair.merge(pair1, pair2));
	}
	
	public static <T> void print(Collection<T> coll) {
		for(T item : coll)
			System.out.println(item);
	}
	public static <T> T getFirst(List<T> list) {
		return list.get(0);
	}
	
	public static <T> List<T> newList() {
		return new ArrayList<T>();
	}
	
	/* Converts a List to Set */
	public static <T> Set<T> toSet(List<T> list) {
		return new HashSet<>(list);
	}
}
