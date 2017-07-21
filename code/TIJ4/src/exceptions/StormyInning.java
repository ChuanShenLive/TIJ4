//: exceptions/StormInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class version, or exceptions 
// derived form the base-class exceptions.
package exceptions;

@SuppressWarnings("serial")
class BaseballException extends Exception {}

@SuppressWarnings("serial")
class Foul extends BaseballException {}

@SuppressWarnings("serial")
class Strike extends BaseballException {}

abstract class Inning {
	public Inning() throws BaseballException {}
	
	public void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}
	
	public abstract void atBat() throws Strike, Foul;
	public void walk() {} // Throws no checked exceptions
}

@SuppressWarnings("serial")
class StormException extends Exception {}

@SuppressWarnings("serial")
class RainedOut extends StormException {}

@SuppressWarnings("serial")
class PopFoul extends Foul {}

interface Storm {
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public StormyInning() 
		throws RainedOut, BaseballException {
		
	}

	public StormyInning(String s) 
		throws Foul, BaseballException {
		
	}
	
	//Regular methods must conform to base class:
	//! public void walk() throws PopFoul {}	// Compile error
	
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	//! public void event() throws RainedOut {}
	
	// You can chose to not throw any exceptions,
	// even if the base version dose:
	public void event() {
		
	}
	
	// If the method doesn't already exist in the
	// base class, the exception is OK.
	public void rainHard() throws RainedOut {
		
	}
	
	// Overridden methods can throw inherited exception:
	public void atBat() throws PopFoul {
		
	}
	
	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch(RainedOut e) {
			System.out.println("Rained out");
		} catch(BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch(Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch(RainedOut e) {
			System.out.println("Rained out");
		} catch(BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
}///:~
