//: generics/CompilerIntelligence.java
package generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        List<? extends Fruit> fList = Arrays.asList(new Apple());
        Apple a = (Apple)fList.get(0); // No warning
        fList.contains(new Apple());// Argument is 'Object'
        fList.indexOf(new Apple());     // Argument is 'Object'
    }
} ///:~
