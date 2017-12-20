//: generics/CaptureConversion.java
package generics;

public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	static void f2(Holder<?> holder) {
		f1(holder);	// Call with captured type
		Object obj = holder.get();
		System.out.println(obj.getClass().getSimpleName());
	}
	static void f3(Holder holder) {
		f1(holder);	// Call with captured type
		Object obj = holder.get();
		System.out.println(obj.getClass().getSimpleName());
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })	
	public static void main(String[] args) {
		Holder raw = new Holder<Integer>(1);
		f1(raw);	// Produces warnings
		f2(raw);	// No warnings
		Holder rawBasic = new Holder();
		rawBasic.set(new Object());	// Warning
		f2(rawBasic);	// No warnings
		// Upcast to Holder<?>, still figures it out:
		Holder<?> wildcarded = new Holder<Double>(1.0);
		f2(wildcarded);
		f3(wildcarded);
	}
} /* Output:
Integer
Integer
Object
Double
*///:~
