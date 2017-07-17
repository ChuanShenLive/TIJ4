//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}
package exceptions;

public class NeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}
	static void g() {
		f();
	}
	public static void main(String[] args) {
		g();
	}
} ///:~
/*
 Exception in thread "main" java.lang.RuntimeException: From f()
	at exceptions.NeverCaught.f(NeverCaught.java:8)
	at exceptions.NeverCaught.g(NeverCaught.java:11)
	at exceptions.NeverCaught.main(NeverCaught.java:14)
 */