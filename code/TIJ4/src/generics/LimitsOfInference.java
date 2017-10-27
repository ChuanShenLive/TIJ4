//: generics/LimitsOfInference.java
package generics;

import java.util.List;
import java.util.Map;

import sc.chuanshen.util.New;
import typeinfo.Person;
import typeinfo.pets.Pet;


public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPeople) {
		
	}
	
	public static void main(String[] args) {
		f(New.map());	// Does not compile????
	}
}
