//: innerclasses/InheritInner.java
// Inheriting an inner class.
package innerclasses;

class WithInner {
	class Inner{}
}

public class InheritInner extends WithInner.Inner {
	// InheritInner() {} // Won't compile
	InheritInner(WithInner wi) {
		wi.super();
	}
}
