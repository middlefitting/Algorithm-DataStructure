package 유형.스택.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		logic(parse());
	}

	private static void logic(char[] arr) {
		Stack<String> stack = new Stack<>();
		LinkedList<Integer> results = new LinkedList<>();
		int num = 0;
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		for (char c : arr) {
			if (map.getOrDefault(c, null) != null || stack.isEmpty()) {
				if (num != 0) {
					stack.add(String.valueOf(num));
					num = 0;
				}
				stack.add(String.valueOf(c));
			} else {
				String top = stack.peek();
				while (!top.equals("[") && !top.equals("]") && !top.equals("(") && !top.equals(")")) {
					int pre = Integer.parseInt(stack.pop());
					num += pre;
					top = stack.peek();
				}

				if (top.equals("(") && c == ')') {
					stack.pop();
					if (num == 0) {
						num = 2;
					} else {
						num *= 2;
					}
				} else if (top.equals("[") && c == ']') {
					stack.pop();
					if (num == 0) {
						num = 3;
					} else {
						num *= 3;
					}
				} else {
					if (num != 0) {
						stack.add(String.valueOf(num));
						num = 0;
					}
					stack.add(String.valueOf(c));
				}
			}

			if (num != 0 && stack.isEmpty()) {
				results.add(num);
				num = 0;
			}
		}
		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(results.stream().mapToInt(Integer::intValue).sum());
		}
	}

	private static char[] parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			char[] arr = br.readLine().toCharArray();
			return arr;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
