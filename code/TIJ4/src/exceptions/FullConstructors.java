//: exceptions/FullConstructors.java
package exceptions;

class MyException extends Exception {
	private static final long serialVersionUID = -644046887201829916L;
	public MyException() {}
	public MyException(String msg) { super(msg); }
}

public class FullConstructors {

	public static void f() throws MyException {
		System.out.println("Throwing MyExcpeiton from f()");
		throw new MyException();
	}
	
	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch(MyException e) {
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
	}
} /* Output:
Throwing MyExcpeiton from f()
exceptions.MyException
	at exceptions.FullConstructors.f(FullConstructors.java:13)
	at exceptions.FullConstructors.main(FullConstructors.java:23)
Throwing MyException from g()
exceptions.MyException: Originated in g()
	at exceptions.FullConstructors.g(FullConstructors.java:18)
	at exceptions.FullConstructors.main(FullConstructors.java:29)
*///:~
