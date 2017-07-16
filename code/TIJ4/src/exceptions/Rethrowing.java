//: exceptions/Rethrowing.java
// Demonstrating fillInStackTrace()
package exceptions;

public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStracTrace()");
			e.printStackTrace(System.out);
		}
		
		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStrackTrace()");
			e.printStackTrace(System.out);
		}
	}
} /* Output:
originating the exception in f()
Inside g(), e.printStackTrace()
java.lang.Exception: thrown from f()
	at exceptions.Rethrowing.f(Rethrowing.java:8)
	at exceptions.Rethrowing.g(Rethrowing.java:13)
	at exceptions.Rethrowing.main(Rethrowing.java:33)
main: printStracTrace()
java.lang.Exception: thrown from f()
	at exceptions.Rethrowing.f(Rethrowing.java:8)
	at exceptions.Rethrowing.g(Rethrowing.java:13)
	at exceptions.Rethrowing.main(Rethrowing.java:33)
originating the exception in f()
Inside h(), e.printStackTrace()
java.lang.Exception: thrown from f()
	at exceptions.Rethrowing.f(Rethrowing.java:8)
	at exceptions.Rethrowing.h(Rethrowing.java:23)
	at exceptions.Rethrowing.main(Rethrowing.java:40)
main: printStrackTrace()
java.lang.Exception: thrown from f()
	at exceptions.Rethrowing.h(Rethrowing.java:27)
	at exceptions.Rethrowing.main(Rethrowing.java:40)
*///:~
