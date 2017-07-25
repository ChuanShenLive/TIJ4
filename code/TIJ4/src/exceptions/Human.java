//: exceptions/Human.java
// Catching exception hierarchies.
package exceptions;

@SuppressWarnings("serial")
class Annoyance extends Exception {}

@SuppressWarnings("serial")
class Sneeze extends Annoyance {}

public class Human {
	@SuppressWarnings("hiding")
	public static void main(String[] args) {
		// Catch the exact type:
		try {
			throw new Sneeze();
		} catch(Sneeze s) {
			System.out.println("Caught Sneeze");
		} catch(Annoyance a) {
			System.out.println("Caught Annoyance");
		}
		// Catch the base type:
		try {
			throw new Sneeze();
		} catch(Annoyance a) {
			System.out.println("Caught Annoyance");
		}
	}
} /* Output:
Caught Sneeze
Caught Annoyance
*///:~
