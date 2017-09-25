package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:SimpleDaemons.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月25日
 */
public class SimpleDaemons implements Runnable {

	public void run(){
		try {
			while(true){
				TimeUnit.MICROSECONDS.sleep(100);
				print(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			print("sleep() interrupted");
		}
	}
	
	private void print(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 5; i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);// Must call before start()
			daemon.start();
		}
		System.out.print("All daemons started");
		//Old style TimeUnit.MICROSECONDS.sleep(175);
		TimeUnit.SECONDS.sleep(1);
	}
	


}
