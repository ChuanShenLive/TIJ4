//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)
package generics;

// class Cat extends ComparablePet implements Comparable<Cat> {
class Cat extends ComparablePet implements Comparable<ComparablePet> {
	public int compareTo(Cat arg) {
		return 0;
	}
}

public class HijackedInterface {

}
