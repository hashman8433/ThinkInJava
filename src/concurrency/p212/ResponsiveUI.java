package concurrency.p212;

import java.io.IOException;

class UnresponsiveUI {
	private volatile double d = 1;
	public UnresponsiveUI() throws IOException {
		while(d > 0)
			d = d + (Math.PI + Math.E) / d;
		System.in.read();
	}
}

/**
 * ClassName:ResponsiveUI.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
public class ResponsiveUI extends Thread {
	private static volatile double d = 1;
	public ResponsiveUI() {
		setDaemon(true);
		start();
	}
	public void run() {
		while(true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}
	public static void main(String[] args) throws IOException {
		//! new UnresponsiveUI(); //Must kill this process
		new ResponsiveUI();
		System.in.read();
		System.out.println(d); // Shows progress
	}
}
