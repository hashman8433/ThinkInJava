package concurrency.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable{
	
	private static int count = 0;
	private int id = count++;
	
	public LiftOff(){
		System.out.println("#" + id + " LiftOff start");
	}
	
	@Override
	public void run() {

		int i = 0;
		while (i++ < 3){
			System.out.print("");
			Thread.yield();
		}
		System.out.println("#" + id + " LiftOff End ");
	}
	
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++){
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
