//: generics/Unconstrained.java
package generics;

class Other {
	
}

class BasicOther extends BasicHolder<Other> {
	
}

public class Unconstrained {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BasicOther b = new BasicOther();
		BasicOther b2 = new BasicOther();
		
		b.set(new Other());
		Other other = b.get();
		b.f();
	}
} /* Output:
Other
*///:~
