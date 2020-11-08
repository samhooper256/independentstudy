package testingpack;

import java.util.*;

public class Test003 {
	
	public static void main(String[] args) {
		new Tor().method();
	}
	static interface Inter1 {
		void take(List<String> l);
		
		List<String> get();
		
		default void method() {
			System.out.println("Inter1 method() body");
		}
		
		default void def2() {
			
		}
	}
	
	static interface Inter2 {
		void take(List<Integer> l);
		
		List<Integer> get();
		
		default void def2() {
			
		}
	}
	
	abstract static class Super1 {
		public void method() {
			System.out.println("Super1 method() body");
		}
	}
	static class Tor extends Super1 implements Inter1, Inter2 {

		@Override
		public void take(List l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List get() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void def2() {
			
		}
		
	}
	
	
}
