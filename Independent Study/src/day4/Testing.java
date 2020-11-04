package day4;

import java.util.*;
import java.util.stream.Collectors;

public class Testing {
	
	public static void main(String[] args) {
		
		List<?> wild; // ? = {String, Number, Integer, Object, etc...}
		
		List<Object> objects = new ArrayList<Object>(); // Object = {Object}
		List<String> strings = new ArrayList<String>(); // String = {String}
		
		wild = strings;
		wild = objects;
		
		Collections.addAll(objects, "3", "4" ,"aefafe", "ieajfaojef");
		
		String[] strs = {"a2342525","z2333","bve","xa","defef"};
		Arrays.sort(strs, new ObjectComparator());
		
		Dog[] dogs = {new Dog(5), new Dog(2), new Dog(7)};
		System.out.println("dogs = " + Arrays.toString(dogs));
		Arrays.sort(dogs);
		System.out.println("dogs = " + Arrays.toString(dogs));
		
		
		System.out.println(Arrays.toString(strs));
		System.out.println();
		takeList(objects);
		takeList(strings);
		
		takeList(wild);
		
		Object o = "String";
		
		if(o instanceof List<?>) {
			
		}
		
		
		// ? super String = {String, CharSequence, Object, ...} 
		// ? extends CharSequence = {CharSequence, String, StringBuilder, ...}
	}
	
	public static void takeList(List<?> list) {
		
	}
	
	// Takes a list and an element, then adds the element to (the end of) that list.
	
	public static <X> void addElement(List<? super X> list, X obj) {
		list.add(obj);
	}
	
	// Takes two sets. Returns a new set containing all elements that occur in exactly one of the input sets.
	// PECS = "Producer extends, Consumer super"
	
	public static <T> Set<T> xor(Set<? extends T> set1, Set<? extends T> set2) {
		Set<T> result = new HashSet<>();
		result.addAll(set1);
		result.addAll(set2);
		Set<T> intersection = new HashSet<>(); //I accidentally named this "union" in class when I meant "intersection."
		intersection.addAll(set1);
		intersection.retainAll(set2);
		result.removeAll(intersection);
		return result;
	}
}

class ObjectComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		return Integer.compare(o1.hashCode(), o2.hashCode());
	}
	
}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length())
			return -1;
		if(o1.length() == o2.length())
			return 0;
		return 1;
	}
	
}

class Dog implements Comparable<Dog> {
	
	int age;
	
	public Dog(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog[age=" + age + "]";
	}

	@Override
	public int compareTo(Dog o) {
		if(this.age == o.age)
			return 0;
		if(this.age < o.age)
			return -1;
		else
			return 1;
	}
}

class Pug extends Dog {
	
	
	public Pug(int age) {
		super(age);
		// TODO Auto-generated constructor stub
	}
}
