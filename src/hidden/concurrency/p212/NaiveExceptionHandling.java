package hidden.concurrency.p212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:NaiveExceptionHandling.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
public class NaiveExceptionHandling {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		try {
			exec.execute(new ExceptionThread());
		} catch (Exception e) {
			// This statement will NOT execute
			System.out.println("Exception has been handled!");
		}
	}
}
