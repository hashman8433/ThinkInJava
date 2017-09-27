package concurrency.p212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:SettingDefaultHandler.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
public class SettingDefaultHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.setDefaultUncaughtExceptionHandler(
				new MyUncaugthExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}

}
