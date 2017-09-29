package hidden.concurrency.p213;

/**
 * ClassName:IntGenerator.java
 * Reason:	 TODO ADD REASON
 * 
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月27日
 */
public abstract class IntGenerator {
	
	private volatile boolean canceled = false;
	public abstract int next();
	// Allow this to be canceled:
	public void cancel() { canceled = true; }
	public boolean isCanceled() { return canceled;}
}
