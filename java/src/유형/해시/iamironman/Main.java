package 유형.해시.iamironman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int win = Integer.parseInt(st.nextToken());
			int lose = Integer.parseInt(st.nextToken());
			int out = Integer.parseInt(st.nextToken());

			HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), st.nextToken());
			}

			boolean flag = false;
			int point = 0;

			for (int i = 0; i < n; i++) {
				String team = br.readLine();
				if (map.getOrDefault(team, "N").equals("W")) {
					point += win;
				} else {
					point = Math.max(point - lose, 0);
				}

				if (point >= out) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println("I AM NOT IRONMAN!!");
			} else {
				System.out.println("I AM IRONMAN!!");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
