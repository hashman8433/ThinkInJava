package concurrency;

import java.util.concurrent.TimeUnit;

import common.AbstractBaseConrrency;

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
	

}
