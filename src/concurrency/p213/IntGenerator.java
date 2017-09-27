package concurrency.p213;

/**
 * ClassName:IntGenerator.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
public abstract class IntGenerator {
	
	private volatile boolean canceled = false;
	public abstract int next();
}
