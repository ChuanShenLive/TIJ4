//: generics/CRGWithBasicHolder.java
package generics;

class Subtype extends BasicHolder<Subtype> {
}

public class CRGWithBasicHolder {
	@SuppressWarnings("unused")
	public static void main(String[] agrs) {
		Subtype st1 = new Subtype();
		Subtype st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
	}
} /* Output:
Subtype
*///:~
