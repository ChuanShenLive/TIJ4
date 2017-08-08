//: strings/Replacing.java
package strings;

import static net.mindview.util.Print.*;

public class Replacing {
	static String s = Splitting.knights;
	
	public static void main(String[] args) {
		print(s);
		print(s.replaceFirst("f\\w+", "located"));
		print(s.replaceAll("shrubbery|tree|herring", "banana"));
	}
} /* Output:
Then, when you hava found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
Then, when you hava located the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
Then, when you hava found the banana, you must cut down the mightiest banana in the forest... with... a banana!
*///:~
