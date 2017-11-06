//: generics/ErasureAndInheritance.java
package generics;

class GenreicBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenreicBase<T> {
}

class Derived2<T> extends GenreicBase<T> {
}

// class Derived3 extends GenericBase<?> {}
// Strange error:
//      unexpected type found : ?
//      required: class or interface without bounds

public class ErasureAndInheritance {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);    // Warning here!
    }
} ///:~
