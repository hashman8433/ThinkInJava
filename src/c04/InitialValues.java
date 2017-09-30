package c04;
// Shows default initial values

class Measurement {
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	protected void print() {
		System.out.println(
				"Data type Inital value\n" +
				"boolean   " + t + "\n" + 
				"char   " + c + "\n" + 
				"byte   " + b + "\n" + 
				"short  " + s + "\n" + 
				"int   " + i + "\n" + 
				"long   " + l + "\n" + 
				"float   " + f + "\n" + 
				"double   " + d);
	}
}

/**
 * ClassName:InitialValues.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月30日
 */
public class InitialValues {
	public static void main(String[] args) {
		Measurement d = new Measurement();
		d.print();
		/* In this case you could also say:
		 * new Measurement().print();
		 */
	}
	protected void print() {
		System.out.println(
				);
	}
}
