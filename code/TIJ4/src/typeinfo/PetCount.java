//: typeinfo/PetCount.java
// Using instanceof
package typeinfo;

import static net.mindview.util.Print.*;

import java.util.HashMap;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

public class PetCount {
	static class PetCounter extends HashMap<String, Integer> {

		private static final long serialVersionUID = 7089367994602161176L;

		public void count(String type) {
			Integer quantity = get(type);
			if(quantity == null) {
				put(type, 1);
			} else {
				put(type, quantity + 1);
			}
		}
	}
	
	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for(Pet pet : creator.createArray(20)) {
			// List each individual pet:
			printnb(pet.getClass().getSimpleName() + " ");
			if(pet instanceof Pet) {
				counter.count("Pet");
			}
			if(pet instanceof Dog) {
				counter.count("Dog");
			}
			if(pet instanceof Mutt) {
				counter.count("Mutt");
			}
			if(pet instanceof Pug) {
				counter.count("Pug");
			}
			if(pet instanceof Cat) {
				counter.count("Cat");
			}
			if(pet instanceof Manx) {
				counter.count("Manx");
			}
			if(pet instanceof EgyptianMau) {
				counter.count("EgyptianMau");
			}
			if(pet instanceof Cymric) {
				counter.count("Cymic");
			}
			if(pet instanceof Rodent) {
				counter.count("Rodent");
			}
			if(pet instanceof Rat) {
				counter.count("Rat");
			}

			if(pet instanceof Mouse) {
				counter.count("Mouse");
			}
			if(pet instanceof Hamster) {
				counter.count("Hamster");
			}
		}
		// Show the counts;
		print();
		print(counter);
	}
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
} /* Output: 
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric 
{EgyptianMau=2, Pug=3, Rat=2, Mouse=2, Cat=9, Cymic=5, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
*///:~
