package 유형.문자열.베스트셀러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>(Math.max(16, (int)(n / 0.75) + 1));
			for (int i = 0; i < n; i++) {
				String key = br.readLine();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			Map.Entry<String, Integer> max = map.entrySet().stream()
				.min(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
					.thenComparing(Map.Entry::getKey))
				.orElseThrow();
			System.out.println(max.getKey());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
