package concurrency.p212;
/**
 * ClassName:Joining.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
// Understanding join()
class Sleeper extends Thread {
	private int duration;
	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(getName() + " was insterrupted." +
			"isInterrupted(): " + isInterrupted());
		}
		System.out.println(getName() + " has awackened");
		
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class Joining extends Thread{
	public static void main(String[] args) {
		Sleeper
			sleepy = new Sleeper("Sleepy", 1500),
			grumpy = new Sleeper("Grumpy", 1500);
		Joiner
			dopey = new Joiner("Depey", sleepy),
			doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}
}
