package hidden.concurrency.p213;

/**
 * ClassName:SynchronizedEvenGenerator.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class SynchronizedEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	
	
	@Override
	public int next() {
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}

}
