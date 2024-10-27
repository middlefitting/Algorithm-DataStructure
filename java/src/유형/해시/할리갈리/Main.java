package 유형.해시.할리갈리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String key = st.nextToken();
				int value = Integer.parseInt(st.nextToken());

				map.put(key, map.getOrDefault(key, 0) + value);
			}

			boolean flag = false;

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() == 5) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
