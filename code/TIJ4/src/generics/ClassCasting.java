//: generics/ClassCasting.java
package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {
	@SuppressWarnings({ "unchecked", "resource", "unused" })
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		// List<Widget> lw1 = List<Widget>.class(in.readObject());
		List<Widget> lw2 = List.class.cast(in.readObject());
	}
} ///:~
