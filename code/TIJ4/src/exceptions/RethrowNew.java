//: exceptions/RethrowNew.java
// Rethrow a different object from the one that was caught.
package exceptions;

@SuppressWarnings("serial")
class OneException extends Exception {
	public OneException(String s) { super(s); }
}

@SuppressWarnings("serial")
class TwoException extends Exception {
	public TwoException(String s) { super(s); }
}

public class RethrowNew {
	public static void f() throws OneException {
		System.out.println("originating the exception in f()");
		throw new OneException("thrown form f()");
	}
	
	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		} catch (TwoException e) {
			System.out.println("Caught in outer try, e.printStrackTrace()");
			e.printStackTrace(System.out);
		}
	}
} /* Output: 
originating the exception in f()
Caught in inner try, e.printStackTrace()
exceptions.OneException: thrown form f()
	at exceptions.RethrowNew.f(RethrowNew.java:16)
	at exceptions.RethrowNew.main(RethrowNew.java:22)
Caught in outer try, e.printStrackTrace()
exceptions.TwoException: from inner try
	at exceptions.RethrowNew.main(RethrowNew.java:26)
*///:~
