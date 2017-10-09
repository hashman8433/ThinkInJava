package c09;

public class Rethrowing {
	public static void f() throws Exception {
		System.out.println(
				"originating the exception in f()");
		throw new Exception("throw from f()");
	}
	public static void g() throws Throwable {
		try {
			f();
		} catch (Exception e) {
			System.out.println(
					"Inside g(), e.printStarkTrace");
			e.printStackTrace();
			throw e;// 17
			// throw e.fillInStackTrace(); // 18
		}
	}
	public static void main(String[] args) throws Throwable {
		try {
			g();
		} catch (Exception e) {
			System.out.println(
					"Caugth in main, e.printStackTrace()");
			e.printStackTrace();
		}
	}
}
