package 유형.백트레킹.에너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
	public static final StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				Anagram.anagram(word);
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	static class Anagram {
		static String[] alphas = new String[26];
		static int n;

		static {
			for (int i = 'a'; i <= 'z'; i++) {
				alphas[i - 97] = String.valueOf((char) i);
			}
		}
		private static void anagram(String word) {
			n = word.length();
			Deque<String> deque = Arrays.stream(word.split("")).collect(Collectors.toCollection(LinkedList::new));
			HashMap<String, Integer> map = new HashMap<>();
			for (String c : deque) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			dfs(0, new LinkedList<>(), map);
		}

		private static void dfs(int depth, Deque<String> deque, HashMap<String, Integer> map) {
			if (depth == n) {
				for (String s : deque) {
					sb.append(s);
				}
				sb.append("\n");
				return;
			}

			for (String alpha : alphas) {
				if (map.getOrDefault(alpha, 0) != 0) {
					map.put(alpha, map.get(alpha) - 1);
					deque.addLast(alpha);
					dfs(depth + 1, deque, map);
					map.put(alpha, map.get(alpha) + 1);
					deque.removeLast();
				}
			}
		}
	}
}


