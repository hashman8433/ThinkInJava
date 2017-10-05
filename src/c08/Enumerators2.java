package c08;

import java.util.*;
// Revisiting Enumerations

class PrintData {
	static void print(Enumeration e) {
		while(e.hasMoreElements())
			System.out.println(
					e.nextElement().toString());
	}
}


public class Enumerators2 {
	public static void main(String[] args) {
		Vector v = new Vector();
		for(int i = 0; i < 5; i++)
			v.addElement(new Mouse(i));
		
		Hashtable h = new Hashtable();
		for(int i = 0; i < 5; i++)
			h.put(new Integer(i), new Hamster(i));
		
		System.out.println("Vector");
		System.out.println(v.elements());
		System.out.println("Hashtable");
		System.out.println(h.elements()); 
	}
}
