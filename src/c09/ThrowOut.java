package c09;

public class ThrowOut {
	public static void main(String[] args) throws Throwable {
		try {
			throw new Throwable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Caught in main()");
		}
	}
}
