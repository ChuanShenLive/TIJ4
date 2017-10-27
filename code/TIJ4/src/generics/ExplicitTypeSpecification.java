//: generics/ExplicitTypeSpecification.java
package generics;

import java.util.List;
import java.util.Map;

import sc.chuanshen.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

public class ExplicitTypeSpecification {
	static void f(Map<Person, List<Pet>> petPeople) {}
	public static void main(String[] args) {
		f(New.<Person, List<Pet>>map());
	}
}
