package 유형.해시.브실이의입시전략;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}

			int result = 0;

			for (int i = 0; i < k; i++) {

				String key = br.readLine();
				result += map.get(key);
				map.remove(key);
			}

			m -= k;

			List<Map.Entry<String, Integer>> collect = map.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
				.collect(Collectors.toList());

			List<Map.Entry<String, Integer>> collect2 = map.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.collect(Collectors.toList());

			int max = result;
			for (int i = 0; i < m; i++) {
				Map.Entry<String, Integer> stringIntegerEntry = collect.get(i);
				max += stringIntegerEntry.getValue();
			}

			int min = result;
			for (int i = 0; i < m; i++) {
				Map.Entry<String, Integer> stringIntegerEntry = collect2.get(i);
				min += stringIntegerEntry.getValue();
			}

			System.out.println(min + " " + max);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
