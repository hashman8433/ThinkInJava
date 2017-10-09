package c08.newcollections;
//Using the Collections unmodifiable methods

import java.util.*;

public class ReadOnly {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Collection1.fill(c); // Insert useful data
		c = Collections.unmodifiableCollection(c);
		Collection1.print(c); // Reading is OK
		//! c.add("one"); // Can't change it

		List a = new ArrayList();
		Collection1.fill(a);
		a = Collections.unmodifiableList(a);
		ListIterator lit = a.listIterator();
		System.out.println(lit.next()); // Reading OK
		//! lit.add("one"); // Can't change it
		
		Set s = new HashSet();
		Collection1.fill(s);
		s = Collections.unmodifiableSet(s);
		Collection1.print(s); // Reading OK
		//! s.add("one"); // Can't change it
		
		
	}
	
	
}
