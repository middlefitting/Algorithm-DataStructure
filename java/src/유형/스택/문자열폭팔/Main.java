package 유형.스택.문자열폭팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			char[] arr = br.readLine().toCharArray();
			Deque<Character> result = new LinkedList<>();
			Deque<Character> stack = new LinkedList<>();
			for (Character c : arr) {
				stack.addLast(c);
			}

			char[] bomb = br.readLine().toCharArray();
			int bombLen = bomb.length;

			int i = 0;
			while (!stack.isEmpty()) {
				if (bomb[i] == stack.peekFirst()) {
					i++;
				} else {
					if (i > 0) {
						i = 0;
						continue;
					}
				}
				result.addLast(stack.pollFirst());

				if (i == bombLen) {
					int j = 0;
					while (j++ < bombLen && !result.isEmpty()) {
						result.pollLast();
					}

					j = 0;

					while (j++ < bombLen && !result.isEmpty()) {
						stack.addFirst(result.pollLast());
					}
					i = 0;
				}

			}

			StringBuilder sb = new StringBuilder();
			while (!result.isEmpty()) {
				sb.append(result.pollFirst());
			}

			if (sb.toString().equals("")) {
				System.out.println("FRULA");
			} else {
				System.out.println(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

