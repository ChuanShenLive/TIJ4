//: generics/Wildcards.java
package generics;

public class Wildcards {
    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);    // Warning:
        // Unchecked call to set(T) as a
        // member of the raw type Holder
        holder.set(new Wildcards());    // Same warning

        // Can't do this; don't have any 'T':
        // T t = holder.get();

        // OK, but type information has been lost;
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        holder.set(arg);    //
    }
}
