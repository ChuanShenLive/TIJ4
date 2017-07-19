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
		throws Foul, BaseballException {
		
	}

	public StormyInning(String s) 
		throws Foul, BaseballException {
		
	}
	
	//Regular methods must conform to base class:
	// public void walk() throws PopFoul {}	// Compile error
	
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	public vid event() throws RAined
	
	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atBat() throws Strike, Foul {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void event() throws BaseballException {
		
	}
}
