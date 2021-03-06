//: generics/GenericWriting.java
package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
        // Incompatible types: found Fruit, required Apple
    }

    static <T> void writeWithWildCard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildCard(apples, new Apple());
        writeWithWildCard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }

}
