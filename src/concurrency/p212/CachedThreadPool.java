package concurrency.p212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		System.out.println("Waiting for LiftOff");
	}

}
