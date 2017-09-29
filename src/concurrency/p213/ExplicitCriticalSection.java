package concurrency.p213;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Using explicit Lock objects to create critical sections.

// Synchronize the entire method:
class ExplicitPairManager1 extends PairManager {
	private Lock lock = new ReentrantLock();
	public synchronized void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

// Use a critical section:
class ExplicitPairManager2 extends PairManager {
	private Lock lock = new ReentrantLock();
	@Override
	public void increment() {
		Pair temp;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}
}


/**
 * ClassName:ExplicitCriticalSection.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月29日
 */
public class ExplicitCriticalSection {
	public static void main(String[] args) {
		PairManager
			pman1 = new ExplicitPairManager1(),
			pman2 = new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	}
}
