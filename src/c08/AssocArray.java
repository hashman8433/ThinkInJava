package c08;

import java.util.*;

// Simple versin of a Dictionary

public class AssocArray extends Dictionary{
	private Vector keys = new Vector();
	private Vector values = new Vector();
	public int size() { return keys.size();}
	
	public boolean isEmpty() {
		return keys.isEmpty();
	}
	
	public Object put(Object key, Object value) {
		keys.addElement(key);
		values.addElement(value);
		return key;
	}
	
	public Object get(Object key) {
		int index = keys.indexOf(key);
		// indexOf() Returns -1 if not found:
		if(index == -1) return null;
		return values.get(index);
	}
	
	public Object remove(Object key) {
		int index = keys.indexOf(key);
		if(index == -1) return null;
		Object returnval = values.elementAt(index);
		keys.removeElementAt(index);
		values.removeElementAt(index);
		return returnval;
	}
	
	public Enumeration keys() {
		return keys.elements();
	}
	
	// Test it:
	public static void main(String[] args) {
		AssocArray aa = new AssocArray();
		for(char c = 'a'; c < 'z'; c++)
			aa.put(String.valueOf(c), String.valueOf(c).toUpperCase()); 
		char[] ca = {'a', 'e', 'i', 'o', 'u'};
		for(int i = 0; i < ca.length; i++) {
			System.out.println("Uppercase: " + aa.get(String.valueOf(ca[i])));
		}
	}

	@Override
	public Enumeration elements() {
		// TODO Auto-generated method stub
		return keys.elements();
	}
}
