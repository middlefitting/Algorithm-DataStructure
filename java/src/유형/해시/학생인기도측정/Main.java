package 유형.해시.학생인기도측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");

			HashMap<String, Integer> map = new HashMap<>();
			Arrays.stream(arr).forEach((x) -> map.put(x, 0));

			for (int i = 0; i < n; i++) {
				Arrays.stream(br.readLine().split(" ")).forEach((key) -> map.put(key, map.get(key) + 1));
			}

			System.out.print(map.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
				.map((entry)-> entry.getKey() + " " + entry.getValue())
				.collect(Collectors.joining("\n")));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
