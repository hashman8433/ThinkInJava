package hidden.concurrency.p212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import hidden.common.AbstractBaseConrrency;

/**
 * ClassName:DaemoFromFactory.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月25日
 */
public class DaemonFromFactory extends AbstractBaseConrrency implements Runnable {

	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.MICROSECONDS.sleep(100);
				print(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			print("Interrupted");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(
				new DaemonThreadFactory());
		for(int i = 0; i < 10; i++)
			exec.execute(new DaemonFromFactory());
		System.out.println("All daemons stared");
		TimeUnit.MICROSECONDS.sleep(500);
	}
}
