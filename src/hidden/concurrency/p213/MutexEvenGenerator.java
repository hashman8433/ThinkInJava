package hidden.concurrency.p213;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:MutexEvenGenerator.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class MutexEvenGenerator extends IntGenerator {
	
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield();// Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			// TODO Auto-generated catch block
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}

}
