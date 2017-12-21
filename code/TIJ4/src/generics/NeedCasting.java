//: generics/NeedCasting.java
package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {

	@SuppressWarnings({ "unused", "unchecked", "resource" })
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		List<Widget> shapes = (List<Widget>)in.readObject();
	}
} ///:~
