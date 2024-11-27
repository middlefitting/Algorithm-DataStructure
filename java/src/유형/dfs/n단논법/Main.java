package 유형.dfs.n단논법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static HashMap<String, LinkedList<String>> map = new HashMap<>();

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());


			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				st.nextToken();
				String b = st.nextToken();

				LinkedList<String> arr = map.getOrDefault(a, new LinkedList<>());
				arr.add(b);
				map.put(a, arr);
			}

			int m = Integer.parseInt(br.readLine());

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				st.nextToken();
				String b = st.nextToken();
				boolean result = dfs(a, b);
				if (result) {
					System.out.println("T");
				} else {
					System.out.println("F");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static boolean dfs(String a, String b) {
		boolean result = false;

		for (String child : map.getOrDefault(a, new LinkedList<>())) {
			if (child.equals(b)) {
				result = true;
			} else if (dfs(child, b)) {
				result = true;
			}
		}

		return result;
	}
}
