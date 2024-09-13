package 유형.해시.패션왕신해빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int m = Integer.parseInt(br.readLine());
				HashMap<String, Integer> map = new HashMap<>();
				for (int j = 0; j < m; j++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					String name = st.nextToken();
					String key = st.nextToken();
					map.put(key, map.getOrDefault(key, 0) + 1);
				}


				logic(map);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void logic(HashMap<String, Integer> map) {
		int result = 1;
		for (String key : map.keySet()) {
			result *= map.get(key) + 1;
		}
		result -= 1;
		System.out.println(result);
	}
}
