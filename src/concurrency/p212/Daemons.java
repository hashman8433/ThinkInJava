package concurrency.p212;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {

	private Thread[] t = new Thread[10];
	@Override
	public void run() {

		for(int i = 0; i < t.length; i++){
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started.");
		}
		for(int i = 0; i < t.length; i++)
			System.out.println("t[" + i + "].isDaemin() = " + 
					t[i].isDaemon() + ". ");
		while(true)
			Thread.yield();
	}

}

class DaemonSpawn implements  Runnable {

	@Override
	public void run() {
		while(true)
			Thread.yield();
	}
	
}
/**
 * ClassName:Daemons.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月25日
 */
public class Daemons {
	public static void main(String[] args) throws InterruptedException{
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ". ");
		// Allow the daemon threads to
		// finish their startup processes:
		TimeUnit.SECONDS.sleep(1);
	}
}
