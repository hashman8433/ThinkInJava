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
	void f1() { i++;}
	void f2() { i += 3; }
}
