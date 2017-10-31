//: generics/TupleList.java
// Combining generic types to make complex generic types.
package generics;

import java.util.ArrayList;

import sc.chuanshen.util.FourTuple;

@SuppressWarnings("serial")
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
	public static void main(String[] args) {
		TupleList<Vehicle, Amphibian, String, Integer> tl =
				new TupleList<Vehicle, Amphibian, String, Integer> ();
		tl.add(TupleTest.h());
		tl.add(TupleTest.h());
		for(FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
			System.out.println(i);
		}
	}
} /* Output:
(generics.Vehicle@15db9742, generics.Amphibian@6d06d69c, hi, 47)
(generics.Vehicle@7852e922, generics.Amphibian@4e25154f, hi, 47)
*///:~