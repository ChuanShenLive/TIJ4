//: generics/SelfBoundingMethods.java
package generics;

public class SelfBoundingMethods {
	static <T extends SelfBounded<T>> T f(T arg) {
		return arg.set(arg).get();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] arg) {
		A a = f(new A());
	}
} ///:~
