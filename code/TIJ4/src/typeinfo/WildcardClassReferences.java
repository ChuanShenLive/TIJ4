//: typeinfo/WildcardClassReferences.java
package typeinfo;

public class WildcardClassReferences {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Class<?> intClass = int.class;
		intClass = double.class;
	}
} ///:~
