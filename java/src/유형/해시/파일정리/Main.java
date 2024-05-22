package 유형.해시.파일정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>(Math.max((int)(n / 0.75f) + 1, 16));

			for (int i = 0; i < n; i++) {
				String extension = br.readLine().split("\\.")[1];
				map.put(extension, map.getOrDefault(extension, 0) + 1);
			}

			String sep = " ";
			String next = "\n";
			List<String> sortedKeys = new ArrayList<>(map.keySet());
			Collections.sort(sortedKeys);
			StringBuilder sb = new StringBuilder();
			for (String key : sortedKeys) {
				sb.append(key).append(sep).append(map.get(key)).append(next);
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
