package concurrency.p213;

/**
 * ClassName:Atomicity.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class Atomicity {
	int i;
	synchronized void f1() { i++; }
	synchronized void f2() { i += 3; }
}
