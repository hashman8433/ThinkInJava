package c08.newcollections;
//Things you can do with Lists

import java.util.*;

public class List1 {
	// Wrap Collection1.fill() for convenience:
	public static List fill(List a) {
		return (List)Collection1.fill(a);
	}
	
	// You can use an Iterator, just as with a
	// Collection, but you can also use random
	// access with get:
	public static void print(List a) {
		for(int i = 0; i < a.size(); i++)
			System.out.println(a.get(i) + " ");
		System.out.println();
	}
	
	public static void basicTest(List a) {
		
	}
}
