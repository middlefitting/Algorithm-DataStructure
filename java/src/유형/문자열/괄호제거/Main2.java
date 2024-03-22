package 유형.문자열.괄호제거;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Main2.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/03/22
 */
public class Main2 {
	public static void main(String[] args) {
		PriorityQueue<String> set = new PriorityQueue<>();
		set.add("dd");
		set.add("cc");
		set.add("pp");
		LinkedHashMap<String, PriorityQueue<String>> dd = new LinkedHashMap<>();
		dd.put("dd", set);
		System.out.println(dd.get("dd"));
		System.out.println(dd.get("dd").remove());
		System.out.println(dd.get("dd").remove());
		System.out.println(dd.get("dd").remove());
	}
}
