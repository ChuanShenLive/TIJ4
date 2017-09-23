//: typeinfo/PetCount4.java
package typeinfo;

import static net.mindview.util.Print.*;
import net.chuanshen.util.TypeCounter;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet : Pets.createArray(20))  {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric 
{Rodent=5, Pet=20, Pug=3, Cat=9, Manx=7, Hamster=1, Dog=6, Cymric=5, Rat=2, Mutt=3, EgyptianMau=2, Mouse=2}
*///:~
