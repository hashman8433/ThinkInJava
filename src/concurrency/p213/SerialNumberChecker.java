package concurrency.p213;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Operations that may seem safe are not.
// when threads are present.
// {Args: 4}

class CircularSet {
	private int[] array;
	private int len;
	private int index = 0;
	public CircularSet(int size) {
		array = new int[size];
		len = size;
		// Initialize to a value not produced
		// by the SerialNumberGenerator:
		for(int i = 0; i < size; i++)
			array[i] = -1;
	}
	public synchronized void add(int i) {
		array[index] = i;
		// Wrap index and write over old elements:
		index = ++index % len;
	}
	
	public synchronized boolean contains(int val) {
		for(int i = 0; i < len; i++) 
			if(array[i] == val) return true;
		return false;
	}
}

/**
 * ClassName:SerialNumberChecker.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class SerialNumberChecker {
	
	private static final int SIZE = 10;
	private static CircularSet serials = 
			new CircularSet(1000);
	private static ExecutorService exec = 
			Executors.newCachedThreadPool();
	
	static class SerialChecker implements Runnable {
		public void run() {
			int serial = 
					SerialNumberGenerator.nextSerialNumber();
			if(serials.contains(serial)) {
				System.out.println("Duplicate: " + serial);
				System.exit(0);
			}
			serials.add(serial);
		}
	}
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		for(int i = 0; i < SIZE; i++)
			exec.execute(new SerialChecker());
		// Stop after n seconds if there's an argument:
		if(args.length > 0) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("No duplicates detected");
			System.exit(0);
		}
			
	}
}
