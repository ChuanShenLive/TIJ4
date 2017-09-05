//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

public class JGrep {

	public static void main(String[] args) throws Exception {
		if(args.length < 2) {
			System.out.println("Usage : java jGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1]);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");
		for(String line : new TextFile(args[0])) {
			m.reset(line);
			while(m.find())
				System.out.println(index++ + ": " +
					m.group() + ": " + m.start());
		}
	}
} /* Output:
0: strings: 4
1: simple: 10
2: the: 28
3: Ssct: 26
4: strings: 8
5: class: 7
6: static: 8
7: String: 25
8: throws: 40
9: System: 3
10: System: 3
11: compile: 22
12: through: 13
13: the: 21
14: the: 34
15: String: 6
16: System: 4
17: start: 26
*///:~
