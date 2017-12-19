//: generics/ClassTypeCapture.java
package generics;

class Building {}
class House extends Building {}

@SuppressWarnings("unchecked")
public class ClassTypeCapture<T> {
    private Class<T> kind;
    private ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f (Object arg) {
        return kind.isInstance(arg);
    }

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
} /* Output:
true
true
false
true
*///:~
