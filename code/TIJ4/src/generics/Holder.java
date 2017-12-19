//: generics/Holder.java

package generics;

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }
    void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    @SuppressWarnings({ "unused", "unlikely-arg-type" })
	public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        // Holder<Fruit> Fruit = Apple; // Cannot upcast
        Holder<? extends Fruit> fruit = Apple;  //OK
        Fruit p = fruit.get();
        d = (Apple) fruit.get();    // Returns 'Object'
        try {
            Orange c = (Orange)fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e);
        }
        // fruit.set(new Apple());      // Cannot call set();
        // fruit.set(new Fruit());      // Cannot call set();
        System.out.println(fruit.equals(d));    // OK
    }
} /* Output: (Sample)
java.lang.ClassCastException: generics.Apple cannot be cast to generics.Orange
true
*///:~
