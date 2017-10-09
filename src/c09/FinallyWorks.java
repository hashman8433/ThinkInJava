package c09;

public class FinallyWorks {
	static int count = 0;
	public static void main(String[] args) {
		while(true) {
			// post-increment is zero first time:
			try {
				if(count++ == 0)
					throw new Exception();
				System.out.println("No exception");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown");
			} finally {
				System.out.println("in finally clause");
				if(count == 2) break; // out of "while"
			}
		}
	}
}
