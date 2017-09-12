//: strings/SplitDemo.java
package strings;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {
	public static void main(String[] args) {
		String input = 
			"This!!unsual use!!of exclamation!!points";
		print(Arrays.toString(
				Pattern.compile("!!").split(input)
		));
		
		// Only do the first three:
		print(Arrays.toString(
				Pattern.compile("!!").split(input, 3)
		));
	}
} /* Output:
[This, unsual use, of exclamation, points]
[This, unsual use, of exclamation!!points]
*///:~