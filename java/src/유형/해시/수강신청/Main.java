package 유형.해시.수강신청;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < m; i++) {
				String student = br.readLine();
				map.put(student, i);
			}

			List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
			entryList.sort(Map.Entry.comparingByValue());
			int idx = 0;

			StringBuilder sb = new StringBuilder();
			while (idx < n && idx < entryList.size()) {
				sb.append(entryList.get(idx).getKey()).append("\n");
				idx++;
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
