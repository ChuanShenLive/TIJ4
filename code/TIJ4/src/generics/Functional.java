//: generics/Functional.java
package generics;

import static net.mindview.util.Print.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Different types of function objects:
interface Combiner<T> {
	T combine(T x, T y);
}

interface UnaryFunction<R, T> {
	R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
	T result();	// Extract result of collecting parameter
}

interface UnaryPredicate<T> {
	boolean test(T x);
}

public class Functional {
	// Calls the Combiner object on each element to combine
	// it with a running result, which is finally returned:
	public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
		Iterator<T> it = seq.iterator();
		if(it.hasNext()) {
			T result = it.next();
			while(it.hasNext()) {
				result = combiner.combine(result, it.next());
			}
			return result;
		}
		// If seq is the empty list:
		return null;	// Or throw exception
	}
	
	// Take a function object and call it on each object in
	// the list, ignoring the return value. The function
	// object may act as a collecting parameter, so it is 
	// returned at the end.
	public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
		for(T t : seq) {
			func.function(t);
		}
		return func;
	}
	
	// Creates a list of results by calling a
	// function object for each object in the list:
	public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
		List<R> result = new ArrayList<R>();
		for(T t : seq) {
			result.add(func.function(t));
		}
		return result;
	}
	
	// Applies a unary predicate to each item in a sequence,
	// and returns a list of items that produced "true":
	public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
		List<T> result = new ArrayList<T>();
		for(T t : seq) {
			if(pred.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	// To use the above generic methods, we need to create
	// function objects to adapt to our particular need:
	static class IntegerAdder implements Combiner<Integer> {
		public Integer combine(Integer x, Integer y) {
			return x + y;
		}
	}
	
	static class IntegerSubtracter implements Combiner<Integer> {
		public Integer combine()
	}
}
