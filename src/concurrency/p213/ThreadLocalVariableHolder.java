package concurrency.p213;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {
	private final int id;
	public Accessor(int idn) { id = idn; }
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	public String toString() {
		return "#" + id + ": " +
				ThreadLocalVariableHolder.get();
	}
}

/**
 * ClassName:ThreadLocalVariableHolder.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月29日
 */
public class ThreadLocalVariableHolder {
	private static ThreadLocal<Integer> value = 
			new ThreadLocal<Integer>() {
		private Random rand = new Random(47);
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};
	public static void increment() {
		value.set(value.get() + 1);
	}
	public static int get() { return value.get(); }
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++)
			exec.execute(new Accessor(i));
		TimeUnit.SECONDS.sleep(3);
		exec.shutdown();
	}
	
}
