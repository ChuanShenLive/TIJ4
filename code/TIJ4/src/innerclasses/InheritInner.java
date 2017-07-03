//: innerclasses/InheritInner.java
// Inheriting an inner class.
package innerclasses;

class WithInner {
	class Inner{}
}

public class InheritInner extends WithInner.Inner {
	// InheritInner() {} // Won't compile
	InheritInner(WithInner wi) {
		//enclosingClassReference.super();
		wi.super();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
} ///:~
