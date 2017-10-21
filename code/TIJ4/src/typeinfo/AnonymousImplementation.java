//: typeinfo/AnonymousImplementation.java
// Anonymous inner classes can't hide from reflection.
package typeinfo;

import typeinfo.interfacea.A;
import static net.mindview.util.Print.*;

@SuppressWarnings("unused")
class AnonyMousA {
	public static A makeA() {
		return new A() {
			public void f() { print("public C.f()"); }
			public void g() { print("public C.g()"); }
			void u() { print("package C.u()"); }
			protected void v() { print("protected C.v()"); }
			private void w() { print("private C.w()"); }
		};
	}
}

public class AnonymousImplementation {
	public static void main(String[] args) throws Exception {
		A a = AnonyMousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the private class:
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
} /* Output:
public C.f()
typeinfo.AnonyMousA$1
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
