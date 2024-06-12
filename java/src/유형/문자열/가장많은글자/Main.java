package 유형.문자열.가장많은글자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, Integer> map = new HashMap<>();
			int max = 0;
			while (true) {
				String temp = br.readLine();
				if (temp == null) {
					break;
				}
				for (int i = 0; i < temp.length(); i++) {
					char c = temp.charAt(i);
					if (c >= 'a' && c <= 'z') {
						map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
						max = Math.max(map.get(String.valueOf(c)), max);
					}
				}
			}
			int finalMax = max;
			String result = map.keySet()
				.stream()
				.sorted()
				.filter((c) -> map.get(c) == finalMax)
				.collect(Collectors.joining());
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
