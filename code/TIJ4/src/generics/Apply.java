//: generics/Apply.java
//{main: ApplyTest}
package generics;

import static net.mindview.util.Print.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
	public static <T, S extends Iterable<? extends T>> 
	void apply(S seq, Method f, Object...  args) {
		try {
			for(T t: seq) {
				f.invoke(t, args);
			}
		} catch(Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}
}

class Shape {
	public void rotate() {
		print(this + " rotate");
	}
	
	public void resize(int newSize) {
		print(this + " resize" + newSize);
	}
}

class Square extends Shape {
}

@SuppressWarnings("serial")
class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for(int i = 0; i < size; i++) {
				// Assumes default constructor:
				add(type.newInstance());
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class ApplyTest {
	public static void main(String[] args) throws Exception {
		List<Shape> shapes = new ArrayList<Shape>();
		for(int i = 0; i < 10; i++) {
			shapes.add(new Shape());
		}
		
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes,  Shape.class.getMethod("resize", int.class), 5);
		
		List<Square> squares = new ArrayList<Square>();
		for(int i = 0; i < 10; i++) {
			squares.add(new Square());
		}
		
		Apply.apply(squares, Shape.class.getMethod("rotate"));
		Apply.apply(squares,  Shape.class.getMethod("resize", int.class), 5);
		
		Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));
		
		SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
		for(int i = 0; i < 5; i++) {
			shapeQ.add(new Shape());
			shapeQ.add(new Square());
		}
		Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
	}
} /* Output:
generics.Shape@4e25154f rotate
generics.Shape@4aa298b7 rotate
generics.Shape@7d4991ad rotate
generics.Shape@28d93b30 rotate
generics.Shape@1b6d3586 rotate
generics.Shape@4554617c rotate
generics.Shape@74a14482 rotate
generics.Shape@1540e19d rotate
generics.Shape@677327b6 rotate
generics.Shape@14ae5a5 rotate
generics.Shape@4e25154f resize5
generics.Shape@4aa298b7 resize5
generics.Shape@7d4991ad resize5
generics.Shape@28d93b30 resize5
generics.Shape@1b6d3586 resize5
generics.Shape@4554617c resize5
generics.Shape@74a14482 resize5
generics.Shape@1540e19d resize5
generics.Shape@677327b6 resize5
generics.Shape@14ae5a5 resize5
generics.Square@7f31245a rotate
generics.Square@6d6f6e28 rotate
generics.Square@135fbaa4 rotate
generics.Square@45ee12a7 rotate
generics.Square@330bedb4 rotate
generics.Square@7ea987ac rotate
generics.Square@12a3a380 rotate
generics.Square@29453f44 rotate
generics.Square@5cad8086 rotate
generics.Square@6e0be858 rotate
generics.Square@7f31245a resize5
generics.Square@6d6f6e28 resize5
generics.Square@135fbaa4 resize5
generics.Square@45ee12a7 resize5
generics.Square@330bedb4 resize5
generics.Square@7ea987ac resize5
generics.Square@12a3a380 resize5
generics.Square@29453f44 resize5
generics.Square@5cad8086 resize5
generics.Square@6e0be858 resize5
generics.Shape@610455d6 rotate
generics.Shape@511d50c0 rotate
generics.Shape@60e53b93 rotate
generics.Shape@5e2de80c rotate
generics.Shape@1d44bcfa rotate
generics.Shape@266474c2 rotate
generics.Shape@6f94fa3e rotate
generics.Shape@5e481248 rotate
generics.Shape@66d3c617 rotate
generics.Shape@63947c6b rotate
generics.Square@2b193f2d rotate
generics.Square@355da254 rotate
generics.Square@4dc63996 rotate
generics.Square@d716361 rotate
generics.Square@6ff3c5b5 rotate
generics.Square@3764951d rotate
generics.Square@4b1210ee rotate
generics.Square@4d7e1886 rotate
generics.Square@3cd1a2f1 rotate
generics.Square@2f0e140b rotate
generics.Shape@7440e464 rotate
generics.Square@49476842 rotate
generics.Shape@78308db1 rotate
generics.Square@27c170f0 rotate
generics.Shape@5451c3a8 rotate
generics.Square@2626b418 rotate
generics.Shape@5a07e868 rotate
generics.Square@76ed5528 rotate
generics.Shape@2c7b84de rotate
generics.Square@3fee733d rotate
*///:~
