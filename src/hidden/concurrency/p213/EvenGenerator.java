package hidden.concurrency.p213;

public class EvenGenerator extends IntGenerator {


	private int currentEvenValue = 0;
	
	@Override
	public int next() {
		++currentEvenValue;// Danger point here!
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] arge) {
		EvenChecker.test(new EvenGenerator());
	}

}
