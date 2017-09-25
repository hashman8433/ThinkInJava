package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:DaemonThreadPoolExecutor.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月25日
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor{

	public DaemonThreadPoolExecutor(){
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(),
				new DaemonThreadFactory()) ;
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(
				new DaemonThreadFactory());
		for(int i = 0; i < 10; i++)
			exec.execute(new DaemonFromFactory());
		System.out.print("All daemons stared");
		TimeUnit.MICROSECONDS.sleep(500);
	}

}
