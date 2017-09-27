package concurrency;

/**
 * ClassName:SimpleThread.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月26日
 */
public class SimpleThread extends Thread{
	private int countDown = 5;
	private static int threadCount = 0;
	public SimpleThread(){
		// Store the thread name:
		super(Integer.toString(++threadCount));
		start();
	}
	public void run(){
		while(true){
			System.out.println(this);
			if(--countDown == 0)
				return ;
		}
	}
	public static void main(String[] args){
		for(int i = 0; i < 5; i++)
			new SimpleThread();
	}
}
