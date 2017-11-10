//: generics/Erased.java
// {CompileTimeError} (Won't compile)
package generics;


public class Erased <T> {
    private final int SIZE = 100;

    @SuppressWarnings("unchecked")
    public void f(Object arg) {
        // if (arg instanceof  T) {}    //ERROR
        // T var = new T();             //ERROR
        // T[] array = new T[SIZE];     //ERROR
        T[] arrag = (T[]) new Object[SIZE]; //Unchecked warning;
    }
}
