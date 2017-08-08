//: strings/IntegerMatch.java
package strings;

public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("567".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
} /* Output:
true
true
false
true
*///:~
