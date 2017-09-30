package c04;

// Demonstration of a simple constructor


/*class Rock {
	Rock() {// This is the constructor
		System.out.println("Creating Rock");
	}
}
*/
class Rock {
	Rock() {
		System.out.println("Create Rock");
	}
	Rock(int i) {
		System.out.println(
				"Creating Rock number " + i);
	}
}

class RockChild extends Rock {
	RockChild(int i) {
		System.out.println("RockChild Create " + i);
	}
}
/**
 * ClassName:SimpleConstructor.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月30日
 */
public class SimpleConstructor {
	public static void main(String[] args) {
		/*for(int i = 0; i < 10; i++)
			new Rock();*/
		for(int i = 0; i < 10; i++)
			new Rock(i);
		new RockChild(1);
	}
}
