package day7;

public class Main {
	
	static int v;
	static Doer b;
	
	static class IntRef {
		int value;
		IntRef(int v) {
			value = v;
		}
	}
	
	public static void main(String[] args) {
		
		final IntRef obj = new IntRef(3);
		
		obj.value = 4;
		obj.value = 45;
		
		final int[] arr = {1,2,3};
		arr[0] = 54;
		
		//target type
		Doer d = () -> { 
			System.out.println("efae");
		};
		
		takeDoer((Doer) (() -> System.out.println("eafe")));
		
		// 3 places lambdas can occur:
		//   1. variable assignments
		//   2. arguments to methods
		//   3. in a cast
		
		int x = 34;
		x = 123;
		
		int y = 123; //"effectively final"
		
		b = () -> {
//			System.out.println(x);
			System.out.println(y);
		};
		
		x = 14;
	}
	
	static void takeDoer(Object arg) {
		b.doSomething();
	}
	
	static void takeInt(int x) {
		int z = 45;
		Doer d = () -> {
			System.out.println(x);
//			z = 3;
		};
	}
	
}

@FunctionalInterface
interface Doer {
	void doSomething();
}