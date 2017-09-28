package concurrency.p213;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:AttemptLocking.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();
	
	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally {
			if(captured)
				lock.unlock();
		}
	}
	
	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + 
					captured);
		} finally {
			if(captured)
				lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final AttemptLocking al = new AttemptLocking();
		al.untimed();// True == lock is available
		al.timed();// True == lock is available
		// Now create a separate task to grab the lock
		new Thread() {
			{setDaemon(true);}
			public void run() {
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield();
		al.untimed();
		al.timed();
	}
}

/* Output
 tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
acquired
tryLock(): false
tryLock(2, TimeUnit.SECONDS): false
*///:~
