//: exceptions/InheritingExceptions.java
package exceptions;

class SimpleException extends Exception {
	private static final long serialVersionUID = 8679539479890183903L;
} 

public class InheritingExceptions {

	public void f() throws SimpleException {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.f();
		} catch (SimpleException e) {
			System.out.println("Caught it!");
		}
	}
} /* Output: 
Throw SimpleException from f()
Caught it!
*///:~
