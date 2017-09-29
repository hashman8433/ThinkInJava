package concurrency.p213;


class DualSynch {
	private Object syncObject =  new Object();
	public synchronized void f() {
		for(int i = 0; i < 100; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}
	public void g() {
		synchronized(syncObject) {
			for(int i = 0; i < 100; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}

/**
 * ClassName:SyncObject.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月29日
 */
public class SyncObject {
	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		ds.g();
	}
}
