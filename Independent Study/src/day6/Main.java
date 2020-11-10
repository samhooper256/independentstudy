package day6;

import java.util.Arrays;

/**
 * @author Sam Hooper
 *
 */
// lambdas
//"functional interface" = one abstract method
interface IntMapper {
	int map(int arg);
}

interface DoubleMapper {
	double map(double arg);
}

public class Main {
	
	static class Doubler implements IntMapper {

		@Override
		public int map(int arg) {
			return arg * 2;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		IntMapper mapper = new IntMapper() {
			@Override
			public int map(int arg) {
				return arg + 7 + arg * 4;
			}
		};
		
		IntMapper mapper2 = x -> {
			return x + 7 + x * 4;
		};
		
		int z = 5;
		
		//every lambda has a "target type"
		IntMapper mapper3 = x -> 2;
		DoubleMapper doubleMapper = x -> 2;
		
		Runnable r = () -> System.out.println("Hello World");
		
//		r.run();
		runNTimes(r, 5);
		runNTimes(() -> System.out.println("message"), 3);
		
		System.out.println(Arrays.toString(applyMapping(arr, x -> x * 3)));
		System.out.println(Arrays.toString(applyMapping(arr, x -> x * x)));
		System.out.println(Arrays.toString(applyMapping(arr, new Doubler())));
		
		System.out.println(Arrays.toString(applyMapping(arr, x -> x * 10)));
		System.out.println(Arrays.toString(applyMapping(arr, x -> x * 10)));
		
	}
	
	private static void runNTimes(Runnable runnable, int times) {
		for(int i = 0; i < times; i++)
			runnable.run();
	}
	
	private static int[] applyMapping(int[] arr, IntMapper mapper) {
		int[] ret = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			ret[i] = mapper.map(arr[i]);
		return ret;
	}
}