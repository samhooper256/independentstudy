package testingpack;

import java.util.*;
import testingpack.OuterClassNG.InnerClassOfNG;
import testingpack.OuterClassG.InnerClassOfG;
/**
 * @author Sam Hooper
 *
 */
public class Test002 {
	public static void main(String[] args) {
		InnerClassOfNG in = null;
		OuterClassG<String>.InnerClassOfG in2 = null;
		
		ArrayList<? extends List<? extends Number>> list1 = null;
		ArrayList<? extends List<Number>> list2 = null;
		ArrayList<List<? extends Number>> list3 = null;
		ArrayList<List<Number>> list4 = null;
		
		list1 = list4;
		list1 = list2;
		list1 = list3;
		
		list2 = list4;
		
		
	}
}
