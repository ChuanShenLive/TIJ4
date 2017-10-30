//: generics/TupleTest2.java
package generics;

import sc.chuanshen.util.FiveTuple;
import sc.chuanshen.util.FourTuple;
import sc.chuanshen.util.ThreeTuple;
import sc.chuanshen.util.Tuple;
import sc.chuanshen.util.TwoTuple;

@SuppressWarnings("rawtypes")
public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return Tuple.tuple("hi", 47);
	}
	
	static TwoTuple f2() {
		return Tuple.tuple("hi", 47);
	}
	
	static ThreeTuple<Amphibian, String, Integer> g() {
		return Tuple.tuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	
	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
} /* Output:
(hi, 47)
(hi, 47)
(generics.Amphibian@15db9742, hi, 47)
(generics.Vehicle@6d06d69c, generics.Amphibian@7852e922, hi, 47)
(generics.Vehicle@4e25154f, generics.Amphibian@70dea4e, hi, 47, 11.1)
*///:~
