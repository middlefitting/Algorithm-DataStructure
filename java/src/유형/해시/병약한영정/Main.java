package 유형.해시.병약한영정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static final String FAIL = "YOU DIED";

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;

			HashMap<String, String> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());
			StringBuilder answer = new StringBuilder();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());

				String append = "";

				for (int j = 0; j < t; j++) {
					if (j != 0) {
						append += " ";
					}

					String temp = map.getOrDefault(st.nextToken(), FAIL);
					append += temp;

					if (temp.equals(FAIL)) {
						append = temp;
						break;
					}
				}
				answer.append(append);
				answer.append("\n");
			}

			System.out.print(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
