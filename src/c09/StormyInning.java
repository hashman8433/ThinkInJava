package c09;
// Overridden methods may throw only the
// exceptions specified in their base-class
// versions, or exceptions derived from the
// base-class exceptions.

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
	Inning() throws BaseballException {}
	void event () throws BaseballException {
		// Doesn't actually have to throw anything
	}
	abstract void atBat() throws Strike, Foul;
	void walk() {} // Throws nothing
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
	void event() throws RainedOut;
	void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
	// OK to add new exceptions for constructors
	// but you must deall with the base constructor
	// exceptions:
	StormyInning() throws RainedOut,
		BaseballException{}
	StormyInning(String s) throws Foul,
		BaseballException{}
	
	// Regular methods must conform to base class:
	//! void walk throws PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	//! public void even() throws RainOut {}
	// If the method doesn't already exist int the
	// base class, the exception is OK:
	@Override
	public void rainHard() throws RainedOut {}	

	// You can choose to not hrow any exceptions
	// even if base version does:
	public void event() {}
	
	// Overridden methods can throw
	// inherited exceptions:
	@Override
	void atBat() throws PopFoul {}
	
	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RainedOut e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BaseballException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Strike not thrown in derived version
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
		} catch (RainedOut e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Strike e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Foul e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BaseballException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
