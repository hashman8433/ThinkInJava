package c12;
//Objects that cannot be modified
//are immune to aliasing.


/**
 * ClassName:Immutable1.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年10月9日
 */
public class Immutable1 {
	private int data;
	public Immutable1(int initVal) {
		data = initVal;
	}
	
	public int read() { return data; }
	
	public boolean nonzero() { return data != 0; }
}
