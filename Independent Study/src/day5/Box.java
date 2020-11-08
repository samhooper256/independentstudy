package day5;

import java.util.*;

public class Box {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {
			{
				add("");
				add("e");
			}
		};
	}
	
	private int a, b;
	private String s;
	
	//"instance initializer"
	{
		System.out.println("Instance initializer");
		s = "eafea";
	}
	
	public Box(int a) {
		super();
		System.out.println("Constructor body");
		a = 3;
		b = 4;
	}
	public Box() {
		this(0);
	}
}
