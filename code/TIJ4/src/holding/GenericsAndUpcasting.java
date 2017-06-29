//: holding/GenericsAndUpcasting.java
package holding;

import java.util.ArrayList;

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple> ();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		for(Apple c : apples){
			System.out.println(c);
		}
	}
} /* Output: (Sample)
holding.GrannySmith@2a139a55
holding.Gala@15db9742
holding.Fuji@6d06d69c
holding.Braeburn@7852e922
*///:~
