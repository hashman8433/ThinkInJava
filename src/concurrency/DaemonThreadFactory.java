package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * ClassName:DaemonTheadFactory.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月25日
 */
public class DaemonThreadFactory implements ThreadFactory{
	
	public Thread newThread(Runnable r){
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
	
}
