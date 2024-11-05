package 유형.해시.걸그룹마스터준석이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			HashMap<String, TreeSet<String>> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String group = br.readLine();
				int cnt = Integer.parseInt(br.readLine());

				TreeSet<String> memebrs = new TreeSet<>();

				for (int j = 0; j < cnt; j++) {
					memebrs.add(br.readLine());
				}

				map.put(group, memebrs);
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {

				String target = br.readLine();
				int type = Integer.parseInt(br.readLine());
				if (type == 0) {

					map.get(target).stream().forEach((s) -> sb.append(s).append("\n"));
				} else {

					for (String key : map.keySet()) {

						if (map.get(key).contains(target)) {

							sb.append(key).append("\n");
						}
					}
				}
			}

			System.out.print(sb);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
