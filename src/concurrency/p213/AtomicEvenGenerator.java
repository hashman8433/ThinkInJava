package concurrency.p213;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
	private AtomicInteger currentEvenValue =
			new AtomicInteger(0);
	
	@Override
	public int next() {
		return currentEvenValue.get();
	}

	public static void main(String[] args) {
		EvenChecker.test(new AtomicEvenGenerator());
	}
}
