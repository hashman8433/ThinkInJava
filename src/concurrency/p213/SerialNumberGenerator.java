package concurrency.p213;

/**
 * ClassName:SerialNumberGenerator.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月28日
 */
public class SerialNumberGenerator {
	private static volatile int serialNumber = 0;
	public static int nextSerialNumber() {
		return serialNumber++; // Not thread-safe
	}
}
