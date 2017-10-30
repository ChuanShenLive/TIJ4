//: sc/chuanshen/util/ContainerMethodDifferences.java
package sc.chuanshen.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sun.javafx.collections.MappingChange.Map;

public class ContainerMethodDifferences {
	
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		for(Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}
	
	static void interfaces(Class<?> type) {
		System.out.print("Interfaces in " + type.getSimpleName() + ": ");
		List<String> result = new ArrayList<String>();
		for(Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}
	
	static Set<String> object = methodSet(Object.class);
	static {
		object.add("clone");
	}
	
	static void difference(Class<?> superset, Class<?> subset) {
		System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
		Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
		comp.removeAll(object);	// Don't show 'Object' methods
		System.out.println(comp);
		interfaces(superset);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		difference(Set.class, Collection.class);
		difference(HashSet.class, Set.class);
		difference(LinkedHashSet.class, HashSet.class);
		difference(TreeSet.class, Set.class);
		difference(List.class, Collection.class);
		difference(ArrayList.class, List.class);
		difference(LinkedList.class, List.class);
		difference(Queue.class, Collection.class);
		difference(PriorityQueue.class, Queue.class);
		
		System.out.println("Map: " + methodSet(Map.class));
		difference(HashMap.class, Map.class);
		difference(LinkedHashMap.class, HashMap.class);
		
		difference(SortedMap.class, Map.class);
		difference(TreeMap.class, Map.class);
	}
} /* Output:
Collection: [add, addAll, clear, contains, containsAll, equals, forEach, hashCode, isEmpty, iterator, parallelStream, remove, removeAll, removeIf, retainAll, size, spliterator, stream, toArray]
Interfaces in Collection: [Iterable]
Set extends Collection, adds: []
Interfaces in Set: [Collection]
HashSet extends Set, adds: []
Interfaces in HashSet: [Set, Cloneable, Serializable]
LinkedHashSet extends HashSet, adds: []
Interfaces in LinkedHashSet: [Set, Cloneable, Serializable]
TreeSet extends Set, adds: [headSet, descendingIterator, descendingSet, pollLast, subSet, floor, tailSet, ceiling, last, lower, comparator, pollFirst, first, higher]
Interfaces in TreeSet: [NavigableSet, Cloneable, Serializable]
List extends Collection, adds: [replaceAll, get, indexOf, subList, set, sort, lastIndexOf, listIterator]
Interfaces in List: [Collection]
ArrayList extends List, adds: [trimToSize, ensureCapacity]
Interfaces in ArrayList: [List, RandomAccess, Cloneable, Serializable]
LinkedList extends List, adds: [offerFirst, poll, getLast, offer, getFirst, removeFirst, element, removeLastOccurrence, peekFirst, peekLast, push, pollFirst, removeFirstOccurrence, descendingIterator, pollLast, removeLast, pop, addLast, peek, offerLast, addFirst]
Interfaces in LinkedList: [List, Deque, Cloneable, Serializable]
Queue extends Collection, adds: [poll, peek, offer, element]
Interfaces in Queue: [Collection]
PriorityQueue extends Queue, adds: [comparator]
Interfaces in PriorityQueue: [Serializable]
Map: [map]
HashMap extends Map, adds: [getOrDefault, computeIfAbsent, values, replace, replaceAll, containsValue, put, remove, compute, get, merge, putAll, keySet, entrySet, containsKey, forEach, clear, isEmpty, computeIfPresent, size, putIfAbsent]
Interfaces in HashMap: [Map, Cloneable, Serializable]
LinkedHashMap extends HashMap, adds: []
Interfaces in LinkedHashMap: [Map]
SortedMap extends Map, adds: [getOrDefault, computeIfAbsent, values, replace, replaceAll, containsValue, put, remove, compute, get, merge, putAll, lastKey, keySet, entrySet, containsKey, forEach, subMap, clear, isEmpty, comparator, computeIfPresent, size, firstKey, headMap, putIfAbsent, tailMap]
Interfaces in SortedMap: [Map]
TreeMap extends Map, adds: [descendingKeySet, getOrDefault, replace, navigableKeySet, higherEntry, containsValue, put, compute, higherKey, merge, floorKey, entrySet, containsKey, subMap, ceilingKey, pollLastEntry, size, firstKey, lowerKey, headMap, tailMap, lowerEntry, ceilingEntry, descendingMap, computeIfAbsent, values, replaceAll, remove, pollFirstEntry, get, putAll, lastKey, firstEntry, keySet, floorEntry, forEach, clear, isEmpty, comparator, computeIfPresent, lastEntry, putIfAbsent]
Interfaces in TreeMap: [NavigableMap, Cloneable, Serializable]
*///:~
