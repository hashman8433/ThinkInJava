package c09.practice;

class TestException extends Exception {
	public TestException(String msg){
		super("a TestException");
	}
	public String toString() {
		return "TestExceptiom toString";
	}
}

public class Practice2 {
	public static void main(String[] args) {
		try {
			throw new TestException("throw TestExcetion");
		} catch (TestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
