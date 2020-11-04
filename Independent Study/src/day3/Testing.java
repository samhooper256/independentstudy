package day3;

import java.io.Serializable;
import java.util.*;


public class Testing {
	public static void main(String[] args) {
		
		record Point(int x, int y) {}
		
		Point p = new Point(3, 4);
		System.out.println(p.x());
		System.out.println(p.y());
		
		//parameterized type
		
		//generic type
//		ArrayList<E>
		//raw type
//		ArrayList
		
		Integer i;
		Double d;
		Number n;
		
		CharSequence csq;
		Serializable s;
		
		StringBuilder sb;
			
		
		ArrayList<Object> objects;
			// is not a supertype of
		ArrayList<String> strings;
		
//		method(3);
//		method(2.3);
		
		Object str = (CharSequence & Serializable) "hello";
		
		List<Double> doubles = List.of(1.2, 3.4, 3.3);
		List<Integer> integers = List.of(5,2,4,3);
		List<Number> numbers = merge(doubles, integers);
		
		//assignment context
//		Double dub = 3; //widening primitive, then boxing conversion - not permitted!
		
		
		List<String> strs = List.of("a","b","c");
		System.out.println(concat(strs));
		
//		StringBuilder sb;
		
		System.out.println(sum(List.of(1,2,6.3,3)));
//		System.out.println(sumNums(new int[] {1,5,2}));
		
		sumNums(3);
		sumNums(3,5,2);
		sumNums(214,45,245,2,52,5);
		
		HashSet<String> st = new HashSet<>();
	}
	
	public static int sumNums(int... arr) {
		int sum = 0;
		for(int i : arr)
			sum += i;
		return sum;
	}
	
	//intersection
	public static double sum(Collection<? extends Number> nums) {
		double sum = 0;
		for(Number n : nums)
			sum += n.doubleValue();
		return sum;
	}
	
	public static <R> List<R> merge(List<? extends R> a, List<? extends R> b) {
		ArrayList<R> list = new ArrayList<>(a);
		list.addAll(b);
		return list;
	}
	
	public static String concat(Collection<? extends CharSequence> collection) {
		StringBuilder result = new StringBuilder();
		for(CharSequence csq : collection)
			result.append(csq.toString());
		return result.toString();
	}
	
}