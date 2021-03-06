//: strings/Groups.java
package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.*;

public class Groups {
	static public final String POEM = 
		"Twas brilling. and the slithy toves\n" +
		"Did gyre and gimble in the wabe.\n" +
		"All mimsy were the borogoves.\n" +
		"And the mome raths outgrabe.\n\n" +
		"Beware the jabberwock, my son.\n" +
		"The jaws that bite. the claws that catch.\n" +
		"Beware the Jubjub bird, and shun\n" +
		"The frumious Bandersnatch.";
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
			.matcher(POEM);
		while(m.find()) {
			printnb("[" + m.group() + "]");
			for(int j = 0; j <= m.groupCount(); j++) 
				printnb("[" + m.group(j) + "]");
			print();
		}
	}
} /* Output:
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves.][were][the borogoves.][the][borogoves.]
[mome raths outgrabe.][mome][raths outgrabe.][raths][outgrabe.]
[jabberwock, my son.][jabberwock,][my son.][my][son.]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*///:~
