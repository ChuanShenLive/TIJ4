//: sc/chuanshen/util/New.java
// Utilities to simplify generic container creation
// by using type argument interface.
package sc.chuanshen.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class New {
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}
	
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	
	public static <T> LinkedList<T> lList() {
		return new LinkedList<T>();
	}
	
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
	
	// Examples:
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String, List<String>> sls = New.map();
		List<String> ls = New.list();
		LinkedList<String> lls = New.lList();
		Set<String> ss = New.set();
		Queue<String> qs = New.queue();
	}
}
