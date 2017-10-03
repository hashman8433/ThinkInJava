package c09;
// Ignoring RuntimeExceptions

public class NeverCaugth {
	static void f() {
		throw new RuntimeException("From f()");
	}
	static void g() {
		f();
	}
	public static void main(String[] args) {
		g();
	}
}
