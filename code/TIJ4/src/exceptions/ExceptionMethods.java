//: exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods.
package exceptions;

import static net.mindview.util.Print.*;

public class ExceptionMethods {

	public static void main(String[] args) {
		try { 
			throw new Exception("My Exception");
		} catch(Exception e) {
			print("Caught Exception");
			print("getMessage(): " + e.getMessage());
			print("getLocalizedMessage(): " + e.getLocalizedMessage());
			print("toString(): " + e);
			print("printstackTrace(): ");
			e.printStackTrace(System.out);
		}
	}
} /* Output:
Caught Exception
getMessage(): My Exception
getLocalizedMessage(): My Exception
toString(): java.lang.Exception: My Exception
printstackTrace(): 
java.lang.Exception: My Exception
	at exceptions.ExceptionMethods.main(ExceptionMethods.java:11)
*///:~
